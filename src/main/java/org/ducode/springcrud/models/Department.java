package org.ducode.springcrud.models;

import javax.validation.constraints.Size;

public class Department {

    @Size(min = 2)
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
