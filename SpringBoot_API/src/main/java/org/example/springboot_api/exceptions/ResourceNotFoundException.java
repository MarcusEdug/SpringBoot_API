package org.example.springboot_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String name;
    private String field;
    private Object value;

    // Constructor
    public ResourceNotFoundException(String name, String field, Object value) {
        super(String.format("%s with %s '%s' was not found", name, field, value));
        this.name = name;
        this.field = field;
        this.value = value;
    }

    // Getters
    public String getItem() {
        return name;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }
}
