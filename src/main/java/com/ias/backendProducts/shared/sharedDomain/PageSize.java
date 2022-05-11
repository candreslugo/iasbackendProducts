package com.ias.backendProducts.shared.sharedDomain;

import org.apache.commons.lang3.Validate;

public class PageSize {
    private final Integer value;

    public PageSize(Integer value) {
        Integer pageSize = value != null ? value : 10;
        Validate.inclusiveBetween(10,30,value,"value page");
        this.value = pageSize;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
