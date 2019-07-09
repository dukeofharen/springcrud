package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.models.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentTransformer implements Transformer<Department, DepartmentDto> {

    @Override
    public Department toModel(DepartmentDto dto) {
        return new Department(dto.getName());
    }

    @Override
    public DepartmentDto toDto(Department model) {
        return new DepartmentDto(model.getName());
    }
}
