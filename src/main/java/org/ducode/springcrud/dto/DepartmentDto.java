package org.ducode.springcrud.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDto {
    private long id;

    private String name;

    private List<EmployeeDto> employees = new ArrayList<>();
}
