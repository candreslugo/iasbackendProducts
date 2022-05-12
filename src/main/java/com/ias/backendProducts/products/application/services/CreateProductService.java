package com.ias.backendProducts.products.application.services;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.models.ProductDTO;
import com.ias.backendProducts.products.application.ports.in.CreateProductUseCase;
import com.ias.backendProducts.products.application.ports.out.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO excute(ProductDTO productDTO) {

        Product product = productDTO.toDomain();
        productRepository.store(product);

        return productDTO;
    }

}
