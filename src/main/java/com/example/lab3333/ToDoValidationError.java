package com.example.lab3333;

import java.util.ArrayList;
import java.util.List;

public class ToDoValidationError {

    private String errorMessage;
    private List<String> errors;

    public ToDoValidationError(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errors = new ArrayList<>();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
