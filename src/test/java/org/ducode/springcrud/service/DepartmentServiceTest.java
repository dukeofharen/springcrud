package org.ducode.springcrud.service;

import org.ducode.springcrud.models.Department;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DepartmentServiceTest {

//    private DepartmentService departmentService;
//
//    @Before
//    public void setUp() throws Exception {
//        departmentService = new DepartmentService();
//    }
//
//    @Test
//    public void getDepartments() {
//        List<Department> departments = departmentService.getDepartments();
//        assertEquals(departmentService.departments, departments);
//    }
//
//    @Test
//    public void createDepartment() {
//        Department department = new Department("testDep");
//        boolean success = departmentService.createDepartment(department);
//        assertTrue(success);
//        assertTrue(departmentService.departments.contains(department));
//    }
//
//    @Test
//    public void createDepartment_Duplicate(){
//        Department dep = new Department("testDep");
//        Department duplicate = new Department("testDep");
//        departmentService.departments.add(dep);
//
//        boolean success = departmentService.createDepartment(duplicate);
//        assertFalse(success);
//
//        assertFalse(departmentService.departments.contains(duplicate));
//    }
}