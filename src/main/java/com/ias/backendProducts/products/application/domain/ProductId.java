package com.ias.backendProducts.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductId {

    private final Integer value;

    public ProductId(Integer value) {
        Validate.notNull(value, "productid can not be null ");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
