package com.ias.backendProducts.infrastructure.controllers;

import com.ias.backendProducts.products.application.models.ProductDTO;
import com.ias.backendProducts.products.application.ports.in.CreateProductUseCase;
import com.ias.backendProducts.products.application.ports.in.DeleteProductUseCase;
import com.ias.backendProducts.products.application.ports.in.QueryProductUseCase;
import com.ias.backendProducts.products.application.ports.in.UpdateProductUseCase;
import com.ias.backendProducts.shared.errors.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductsController {

    private final CreateProductUseCase createProductUseCase;
    private final QueryProductUseCase queryProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    public ProductsController(CreateProductUseCase createProductUseCase, QueryProductUseCase queryProductUseCase, DeleteProductUseCase deleteProductUseCase, UpdateProductUseCase updateProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.queryProductUseCase = queryProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            ProductDTO product = createProductUseCase.excute(productDTO);
            return ResponseEntity.ok(product);

        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError aplicationError = new ApplicationError(
                    "InputValidation",
                    "Bad input data: " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            ApplicationError aplicationError = new ApplicationError(
                    "SystemError",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id) {
        try {
            Optional<ProductDTO> productDTO = queryProductUseCase.excute(id);
            return productDTO.isPresent() ? ResponseEntity.ok(productDTO) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError aplicationError = new ApplicationError(
                    "InputValidation",
                    "Bad input data " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            ApplicationError aplicationError = new ApplicationError(
                    "SystemError",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public ResponseEntity<?> update( @RequestBody ProductDTO productDTO) {
        try {
            ProductDTO product = updateProductUseCase.excute(productDTO);
            return ResponseEntity.ok(product);
        } catch (IllegalArgumentException | NullPointerException e) {
            ApplicationError aplicationError = new ApplicationError(
                    "InputValidation",
                    "Bad input data " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aplicationError);
        } catch (Exception exception) {
            ApplicationError aplicationError = new ApplicationError(
                    "SystemError",
                    exception.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(aplicationError);
        }
    }

    @RequestMapping(value = "products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            deleteProductUseCase.excute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
