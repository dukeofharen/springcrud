package org.ducode.springcrud.service;

import org.ducode.springcrud.models.Department;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class DepartmentService {

    List<Department> departments;

    public DepartmentService() {
        this.departments = new ArrayList<>();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public boolean createDepartment(@Valid Department department) {
        for (Department dep : departments) {
            if (dep.getName().equals(department.getName())) {
                return false;
            }
        }

        return departments.add(department);
    }
}
