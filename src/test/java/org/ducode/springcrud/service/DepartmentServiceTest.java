package org.ducode.springcrud.service;

import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.repository.DepartmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
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

        verify(departmentRepository, times(1)).getDepartments();
        assertEquals(departmentsFromRepository, departments);
    }

    @Test
    public void createDepartment() {
        Department department = new Department();
        department.setName("testDep");

        when(departmentRepository.createDepartment(department)).thenReturn(true);

        boolean success = departmentService.createDepartment(department);
        assertTrue(success);
        verify(departmentRepository, times(1)).createDepartment(department);
    }
}