package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.dto.EmployeeDto;
import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentTransformer implements Transformer<Department, DepartmentDto> {

    @Autowired
    private EmployeeTransformer employeeTransformer;

    @Override
    public Department toModel(DepartmentDto dto) {
        Department department = new Department();
        department.setName(dto.getName());

        List<Employee> employees = dto.getEmployees().stream()
                .map(this.employeeTransformer::toModel)
                .peek(e -> department.addEmployee(e))
                .collect(Collectors.toList());
        department.setEmployees(employees);
        return department;
    }

    @Override
    public DepartmentDto toDto(Department model) {
        DepartmentDto dto = new DepartmentDto();
        dto.setName(model.getName());

        List<EmployeeDto> employees = model.getEmployees().stream()
                .map(this.employeeTransformer::toDto)
                .collect(Collectors.toList());
        dto.setEmployees(employees);

        dto.setId(model.getId());
        return dto;
    }
}
