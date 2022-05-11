package com.ias.backendProducts.types.application.domain;

import org.apache.commons.lang3.Validate;

public class TypeName {

    private final String value;

    public TypeName(String value) {
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
