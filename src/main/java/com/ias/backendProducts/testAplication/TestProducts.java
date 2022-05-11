package com.ias.backendProducts.testAplication;

import com.ias.backendProducts.products.application.domain.*;

public class TestProducts {
    public static void main(String[] args) {
        try {
            ProductId productId = new ProductId(123);
            ProductName productName = new ProductName("headphones");
            ProductPrice productPrice = new ProductPrice(1234);
            ProductDiscount productDiscount = new ProductDiscount(70);
            ProductType productType = new ProductType(2);
            Product product = new Product(productId,productType,productName,productPrice,productDiscount);
        } catch (NullPointerException exception) {
            System.out.println("error" + exception.getMessage());
        }
    }
}
