package org.ducode.springcrud.transformer;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.models.Department;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DepartmentTransformerTest {

    private EmployeeTransformer employeeTransformer;
    private DepartmentTransformer departmentTransformer;

    @Before
    public void setUp() throws Exception {
        employeeTransformer = mock(EmployeeTransformer.class);
        departmentTransformer = new DepartmentTransformer(employeeTransformer);
    }

    @Test
    public void toModel() {
        DepartmentDto dto = new DepartmentDto();
        dto.setName("test123");

        Department department = departmentTransformer.toModel(dto);

        assertEquals(dto.getName(), department.getName());
    }

    @Test
    public void toDto() {
        Department department = new Department();
        department.setName("test123");

        DepartmentDto dto = departmentTransformer.toDto(department);

        assertEquals(department.getName(), dto.getName());
    }
}