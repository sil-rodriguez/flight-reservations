package com.airline.demo.validation;

import java.util.List;

public interface Validator<T> {

    List<String> validate(T request);
}
