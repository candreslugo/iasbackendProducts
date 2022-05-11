package com.ias.backendProducts.types.application.ports.out;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.shared.sharedDomain.PageQuery;
import com.ias.backendProducts.types.application.domain.TypeId;
import com.ias.backendProducts.types.application.domain.Types;

import java.util.List;

public interface TypeRepository {

    Integer Store(Types types);


    Integer store(Product product);
    Product get(TypeId typeId);
    void update(Types types);
    void delete(TypeId typeId);
    List<Product> getProduct(PageQuery pageQuery);
}
