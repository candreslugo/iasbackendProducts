package com.ias.backendProducts.products.application.ports.out;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.shared.sharedDomain.PageQuery;

import java.util.List;

public interface ProductsRepository {

    Integer store(Product product);
    Product get(ProductId productId);
    void update(Product product);
    void delete(ProductId productId);
    List<Product> getProduct(PageQuery pageQuery);
}
