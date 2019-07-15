package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.EmployeeDto;
import org.ducode.springcrud.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTransformer implements Transformer<Employee, EmployeeDto> {
    @Override
    public Employee toModel(EmployeeDto dto) {
        return new Employee(dto.getName());
    }

    @Override
    public EmployeeDto toDto(Employee model) {
        return new EmployeeDto(model.getName());
    }
}
