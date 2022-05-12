package com.ias.backendProducts.products.application.ports.out;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.shared.sharedDomain.PageQuery;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void store(Product product);
    Optional<Product> get(ProductId productId);
    void update(Product product);
    void delete(ProductId productId);
    List<Product> getProducts(PageQuery pageQuery);
}
