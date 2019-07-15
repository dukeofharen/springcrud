package org.ducode.springcrud.service;

import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.repository.DepartmentRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class DepartmentServiceTest {

    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        departmentRepository = mock(DepartmentRepository.class);
        departmentService = new DepartmentService(departmentRepository);
    }

    @Test
    public void getDepartments() {
        List<Department> departmentsFromRepository = new ArrayList<>();

        Department department = new Department();
        department.setName("testDepartment");

        departmentsFromRepository.add(department);
        when(departmentRepository.getDepartments()).thenReturn(departmentsFromRepository);

        List<Department> departments = departmentService.getDepartments();
        assertEquals(departmentsFromRepository, departments);
    }

    @Test
    public void createDepartment() {
        Department department = new Department();
        department.setName("testDep");

        when(departmentRepository.createDepartment(department)).thenReturn(true);

        boolean success = departmentService.createDepartment(department);
        assertTrue(success);
        verify(departmentRepository).createDepartment(department);
    }
}