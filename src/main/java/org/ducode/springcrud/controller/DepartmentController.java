package org.ducode.springcrud.controller;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.service.DepartmentService;
import org.ducode.springcrud.transformer.DepartmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentTransformer transformer;

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(
            DepartmentTransformer transformer,
            DepartmentService departmentService) {
        this.transformer = transformer;
        this.departmentService = departmentService;
    }

    @GetMapping("/api/department")
    public List<DepartmentDto> getGepartment() {
        List<DepartmentDto> dtos = new ArrayList<>();
        for (Department dep : departmentService.getDepartments()) {
            dtos.add(transformer.toDto(dep));
        }

        return dtos;
    }

    @PostMapping("/api/department")
    public ResponseEntity createDepartment(@RequestBody DepartmentDto dto) {
        Department department = this.transformer.toModel(dto);
        departmentService.createDepartment(department);

        return ResponseEntity.created(URI.create("")).build();
    }
}
