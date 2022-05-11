package com.ias.backendProducts.infrastructure.adapters.out;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.products.application.ports.out.ProductsRepository;
import com.ias.backendProducts.shared.sharedDomain.PageQuery;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class SqlProductsRepository implements ProductsRepository {
    @Override
    public Integer store(Product product) {
        return null;
    }

    @Override
    public Product get(ProductId productId) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(ProductId productId) {

    }

    @Override
    public List<Product> getProduct(PageQuery pageQuery) {
        return null;
    }
}
