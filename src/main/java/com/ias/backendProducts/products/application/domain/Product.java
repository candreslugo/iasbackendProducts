package com.ias.backendProducts.products.application.domain;

public class Product {

    private final ProductId productId;
    private final ProductType typeOfProduct;
    private final ProductName name;
    private final ProductPrice price;
    private final ProductDiscount discount;

    public Product(ProductId productId, ProductType typeOfProduct, ProductName name, ProductPrice price, ProductDiscount discount) {
        this.productId = productId;
        this.typeOfProduct = typeOfProduct;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }


    public ProductId getProductId() {
        return productId;
    }

    public ProductType getTypeOfProduct() {
        return typeOfProduct;
    }

    public ProductName getName() {
        return name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public ProductDiscount getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", typeOfProduct=" + typeOfProduct +
                ", name=" + name +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
