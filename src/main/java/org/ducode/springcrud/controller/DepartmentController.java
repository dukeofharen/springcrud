package org.ducode.springcrud.controller;

import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.transformer.DepartmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentTransformer transformer;

    List<Department> departments;

    @Autowired
    public DepartmentController(DepartmentTransformer transformer) {
        this.transformer = transformer;
        this.departments = new ArrayList<>();
    }

    @GetMapping("/api/department")
    public ResponseEntity<List<DepartmentDto>> getGepartment() {
        List<DepartmentDto> dtos = new ArrayList<>();
        for (Department dep : departments) {
            dtos.add(transformer.toDto(dep));
        }

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/api/department")
    public ResponseEntity createDepartment(@RequestBody DepartmentDto dto) {
        departments.add(this.transformer.toModel(dto));

        return ResponseEntity.created(URI.create("")).build();
    }
}
