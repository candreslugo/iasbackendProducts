package com.ias.backendProducts.types.application.model;

import com.ias.backendProducts.types.application.domain.TypeId;
import com.ias.backendProducts.types.application.domain.TypeName;
import com.ias.backendProducts.types.application.domain.Types;

public class TypeDTO {

    private final Integer typeId;
    private  final String typeName;

    public TypeDTO(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Types toDomain(){
        return new Types(new TypeId(typeId),
                new TypeName(typeName));
    }

    public static TypeDTO fronDomain(Types types){
        return new TypeDTO(
                types.getTypeId().getValue(),
                types.getTypeName().getValue());
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
