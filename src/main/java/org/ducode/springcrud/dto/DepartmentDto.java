package org.ducode.springcrud.dto;

public class DepartmentDto {
    private String name;

    public DepartmentDto(String name) {
        this.name = name;
    }

    public DepartmentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
