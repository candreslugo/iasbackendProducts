package com.ias.backendProducts.testAplication;

import com.ias.backendProducts.types.application.domain.TypeId;
import com.ias.backendProducts.types.application.domain.TypeName;
import com.ias.backendProducts.types.application.domain.Types;

public class testType {

    public static void main(String[] args) {
        try {
            TypeId typeId = new TypeId(567);
            TypeName typeName = new TypeName("electronico");

            Types types = new Types(typeId, typeName);
        } catch (NullPointerException exception) {
            System.out.println("error" + exception.getMessage());
        }
    }
}
