package com.ias.backendProducts.products.application.services;

import com.ias.backendProducts.products.application.domain.Product;
import com.ias.backendProducts.products.application.domain.ProductId;
import com.ias.backendProducts.products.application.models.ProductDTO;
import com.ias.backendProducts.products.application.ports.in.DeleteProductUseCase;
import com.ias.backendProducts.products.application.ports.out.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DeleteProductService implements DeleteProductUseCase {

    public final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDTO> excute(Integer id) {

        ProductId productId = new ProductId(id);
        Optional<Product> product = productRepository.get(productId);
        return product.map(product2 -> {
            ProductDTO productDTO = ProductDTO.fronDomain(product2);
            return productDTO;
        });
    }
}
