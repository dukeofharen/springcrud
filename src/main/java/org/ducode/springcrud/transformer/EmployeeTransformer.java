package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.EmployeeDto;
import org.ducode.springcrud.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransformer implements Transformer<Employee, EmployeeDto> {
    @Override
    public Employee toModel(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee model) {
        EmployeeDto dto = new EmployeeDto();
        dto.setName(model.getName());
        return dto;
    }
}
