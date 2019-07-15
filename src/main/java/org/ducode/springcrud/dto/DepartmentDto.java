package org.ducode.springcrud.dto;

import java.util.List;

public class DepartmentDto {
    private long id;

    private String name;

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    private List<EmployeeDto> employees;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
