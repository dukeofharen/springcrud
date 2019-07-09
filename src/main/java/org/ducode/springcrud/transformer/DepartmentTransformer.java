package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.models.Department;

public class DepartmentTransformer implements Transformer<Department, DepartmentDto> {

    @Override
    public Department toModel(DepartmentDto dto) {
        return null;
    }

    @Override
    public DepartmentDto toDto(Department model) {
        return null;
    }
}
