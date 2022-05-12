package com.ias.backendProducts.commons;

public interface UseCase<Input, Output> {
    Output excute(Input input);
}
