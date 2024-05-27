package com.dan232.pricer.comparator.adapter;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.model.ProductPriced;
import com.dan232.pricer.comparator.model.Shop;
import com.dan232.pricer.comparator.model.ShopPrice;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.postgresql.PriceRepo;
import com.dan232.pricer.postgresql.ProductRepo;
import com.dan232.pricer.postgresql.entity.Category;
import com.dan232.pricer.postgresql.entity.PriceRel;
import com.dan232.pricer.postgresql.entity.Product;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductRepository implements ProductPort {

    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;

    public ProductRepository(ProductRepo productRepo, PriceRepo priceRepo) {
        this.productRepo = productRepo;
        this.priceRepo = priceRepo;
    }

    @Override
    public Set<ProductBasic> getAllProducts() {
        return productRepo.findAll().stream().map(this::toModel).collect(Collectors.toSet());
    }

    @Override
    public Set<ProductBasic> getProductsByCategory(String category) {
        return productRepo.findByCategory(category).stream().map(this::toModel).collect(Collectors.toSet());
    }

    @Override
    public Optional<ProductPriced> getProductByEan(String id) {
        return productRepo.findById(new BigInteger(id))
                .map(product -> new ProductPriced(this.toModel(product),
                        priceRepo.findByProduct(product).stream().map(this::toModel).toList()));

    }

    private ShopPrice toModel(PriceRel price) {
        // TODO: Implement send cost
        return new ShopPrice(toModel(price.getShop()), price.getPrice(), 0);
    }

    private Shop toModel(com.dan232.pricer.postgresql.entity.Shop shop) {
        try {
            return new Shop(shop.getName(), URI.create(shop.getHomesite()).toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private ProductBasic toModel(Product product) {
        // TODO: Implement min price
        URL image = null;
        try {
            image = new URI(product.getImage()).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            // DO NOTHING
        }

        return new ProductBasic(product.getName(), 100,
                product.getCategories().stream().map(Category::getName).toList(),
                image);
    }
}
