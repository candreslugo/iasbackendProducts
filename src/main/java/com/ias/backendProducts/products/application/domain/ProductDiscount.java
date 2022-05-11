package com.ias.backendProducts.products.application.domain;

import org.apache.commons.lang3.Validate;

public class ProductDiscount {

    private final Integer value;

    public ProductDiscount(Integer value) {
        Validate.notNull(value,"product can not be null");
        Integer star = 0 , end = 80;
        Validate.inclusiveBetween(star , end , value);

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
