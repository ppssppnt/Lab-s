package com.example.lab3333;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ToDoValidationErrorBuilder {

    public static ToDoValidationError fromBindingErrors(Errors errors) {
        ToDoValidationError error = new ToDoValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
        List<String> errorDetails = new ArrayList<>();
        for (FieldError fieldError : errors.getFieldErrors()) {
            errorDetails.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        error.setErrors(errorDetails);
        return error;
    }
}
