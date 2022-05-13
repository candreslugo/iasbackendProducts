package com.ias.backendProducts.products.application.models;

import com.ias.backendProducts.products.application.domain.*;

public class ProductDTO {
    private Integer productId;
    private Integer productType;
    private String productName;
    private Integer productPrice;
    private Integer productDiscount;

    public ProductDTO(Integer pruductId, Integer productType, String productName, Integer productPrice, Integer productDiscount) {
        this.productId = pruductId;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
    }

    public Product toDomain() {
        return new Product(
                new ProductId(productId),
                new ProductType(productType),
                new ProductName(productName),
                new ProductPrice(productPrice),
                new ProductDiscount(productDiscount)
        );
    }

    public  static ProductDTO fronDomain(Product product){
        return new ProductDTO(
                product.getProductId().getValue(),
                product.getTypeOfProduct().getValue(),
                product.getName().getValue(),
                product.getPrice().getValue(),
                product.getDiscount().getValue()
        );

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Integer productDiscount) {
        this.productDiscount = productDiscount;
    }
}

