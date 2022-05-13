package com.ias.backendProducts.products.application.ports.in;

import com.ias.backendProducts.commons.UseCase;
import com.ias.backendProducts.products.application.models.ProductDTO;

import java.util.Optional;

public interface DeleteProductUseCase extends UseCase<Integer, Optional<ProductDTO>> {
}
