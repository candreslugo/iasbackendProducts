package com.ias.backendProducts.types.application.domain;

import org.springframework.beans.factory.annotation.Value;

public class Types {

    private final TypeId typeId;
    private  final TypeName typeName;

    public Types(TypeId typeId, TypeName typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public TypeId getTypeId() {
        return typeId;
    }

    public TypeName getTypeName() {
        return typeName;
    }
}
