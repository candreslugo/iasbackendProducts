package com.ias.backendProducts.products.application.services;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.models.ProductDTO;
import com.ias.backendProducts.products.application.ports.in.UpdateProductUseCase;
import com.ias.backendProducts.products.application.ports.out.ProductRepository;

public class UpdateProductService implements UpdateProductUseCase {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO excute(ProductDTO productDTO) {


        Product product = productDTO.toDomain();
        productRepository.store(product);
        return null;
    }
}
