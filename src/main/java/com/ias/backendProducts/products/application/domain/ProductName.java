package com.ias.backendProducts.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductName {
    private final String value;

    public ProductName(String value) {
        Validate.notNull(value,"product can not be nul");
        Validate.isTrue(value.length()<40,"product name can not be langer than 40 cararcters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
