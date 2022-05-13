package com.ias.backendProducts.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductName {
    private final String value;

    public ProductName(String value) {
        Validate.notNull(value,"productname can not be nul");
        Validate.isTrue(value.length()<20,"product name can not be langer than 20 cararcters");
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
