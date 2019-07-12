package org.ducode.springcrud.service;

import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.getDepartments();
    }

    @Transactional
    public boolean createDepartment(@Valid Department department) {
        return departmentRepository.createDepartment(department);
    }
}
