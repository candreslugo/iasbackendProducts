package com.ias.backendProducts.types.application.domain;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Value;

public class TypeId {

    private final Integer value;

    public TypeId(Integer value) {
        Validate.notNull(value,"product can not be nul");
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
