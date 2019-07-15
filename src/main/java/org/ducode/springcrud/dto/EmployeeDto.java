package org.ducode.springcrud.dto;

public class EmployeeDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDto() {
    }

    public EmployeeDto(String name) {
        this.name = name;
    }
}
