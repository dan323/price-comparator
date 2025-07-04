// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.PriceRel;
import com.dan232.pricer.postgresql.entity.PriceRelId;
import com.dan232.pricer.postgresql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface PriceRepo extends JpaRepository<PriceRel, PriceRelId> {

    /**
     * Look for the history of price for a specific product from a date.
     *
     * @param product Product to look at
     * @param cutoffDate date in the past to start history from
     * @return The prices for the given product from the given date
     */
    @Query("""
        SELECT pr
        FROM PriceRel pr
        WHERE pr.productShop.product = :product
        AND pr.date >= :cutoffDate
        """)
    Set<PriceRel> findByProductLast30Days(@Param("product") Product product,
                                          @Param("cutoffDate") Date cutoffDate);

    /**
     * Find the last price of a product for each shop where it is available.
     *
     * @param product Product to look for
     * @return Prices for the product that were known last
     */
    @Query("""
        SELECT pr
        FROM PriceRel pr
        JOIN pr.productShop ps
        JOIN ps.shop s
        WHERE pr.productShop.product = :product
        AND pr.date = (
           SELECT MAX(pr2.date)
           FROM PriceRel pr2
           WHERE pr2.productShop.shop = pr.productShop.shop
             AND pr2.productShop.product = :product
         )
        """)
    Set<PriceRel> findByProduct(@Param("product") Product product);

    /**
     * For each product find the cheapest price among the latest prices.
     *
     * @return least price among the latest known
     */
    @Query(value = """
    SELECT pr.product AS ean, MIN(pr.price) AS minPrice
    FROM price_rel pr
    JOIN LATERAL (
        SELECT shop, MAX(date) AS last_scrape
        FROM price_rel
        WHERE product = pr.product
        GROUP BY shop
    ) latest ON latest.shop = pr.shop AND pr.date = latest.last_scrape
    GROUP BY pr.product
    """, nativeQuery = true)
    List<EanPriceProjection> findMinPricesForLastScrapes();
}
