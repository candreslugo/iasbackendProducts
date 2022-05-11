package com.ias.backendProducts.shared.sharedDomain;

import org.apache.commons.lang3.Validate;

public class Page {
    private final Integer value;

    public Page(Integer value) {
        Integer page = value != null ? value : 1;
        Validate.inclusiveBetween(1,10,value,"page value");
        this.value = page;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
