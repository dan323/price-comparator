package com.dan232.pricer.adapter.state;

import com.dan232.pricer.postgresql.PriceRepo;
import com.dan232.pricer.postgresql.ProductRepo;
import com.dan232.pricer.postgresql.ProductShopRepo;
import com.dan232.pricer.postgresql.ShopRepo;
import com.dan232.pricer.postgresql.entity.PriceRel;
import com.dan232.pricer.postgresql.entity.Product;
import com.dan232.pricer.postgresql.entity.ProductShop;
import com.dan232.pricer.postgresql.entity.Shop;
import com.dan232.pricer.scraper.model.WebProductPrice;
import com.dan232.pricer.scraper.port.SavePort;
import jakarta.transaction.Transactional;

import java.math.BigInteger;

public class DBSave implements SavePort {

    private final ProductRepo productRepo;
    private final ShopRepo shopRepo;
    private final ProductShopRepo productShopRepo;
    private final PriceRepo priceRepo;

    public DBSave(ProductRepo productRepo, ShopRepo shopRepo,
                  ProductShopRepo productShopRepo, PriceRepo priceRepo) {
        this.productRepo = productRepo;
        this.shopRepo = shopRepo;
        this.productShopRepo = productShopRepo;
        this.priceRepo = priceRepo;
    }

    @Transactional
    @Override
    public WebProductPrice save(WebProductPrice webProductPrice) {
                // 1. Buscar o crear Product
                BigInteger ean = new BigInteger(webProductPrice.EAN());
                Product product = productRepo.findById(ean).orElseGet(() -> {
                    Product p = new Product();
                    p.setEan(ean);
                    p.setName(webProductPrice.productName());
                    p.setImage(webProductPrice.image().toString());
                    return productRepo.save(p);
                });

                // 2. Buscar o crear Shop (suponiendo que el nombre es único)
                Shop shop = shopRepo.findByName(webProductPrice.shopName())
                        .orElseGet(() -> {
                            Shop s = new Shop();
                            s.setName(webProductPrice.shopName());
                            s.setHomesite(webProductPrice.homeSite().toString());
                            return shopRepo.save(s);
                        });

                // 3. Buscar o crear ProductShop
                ProductShop productShop = productShopRepo.findByProductAndShop(product, shop)
                        .orElseGet(() -> {
                            ProductShop ps = new ProductShop();
                            ps.setProduct(product);
                            ps.setShop(shop);
                            ps.setBuyUrl(webProductPrice.homeSite().toString());
                            return productShopRepo.save(ps);
                        });

                // 4. Crear PriceRel con fecha actual
                PriceRel priceRel = new PriceRel();
                priceRel.setProductShop(productShop);
                priceRel.setDateAsNow();
                priceRel.setPrice(webProductPrice.price());
                priceRepo.save(priceRel);

                return webProductPrice;

    }
}
