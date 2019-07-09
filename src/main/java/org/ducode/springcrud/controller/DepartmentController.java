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

@RestController
public class DepartmentController {
    private DepartmentTransformer transformer;

    @Autowired
    public DepartmentController(DepartmentTransformer transformer) {
        this.transformer = transformer;
    }

    @GetMapping("/api/department")
    public ResponseEntity<DepartmentDto> getGepartment() {
        Department dep = new Department("Test");
        DepartmentDto dto = this.transformer.toDto(dep);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/api/department")
    public ResponseEntity createDepartment(@RequestBody DepartmentDto dto) {
        Department dep = this.transformer.toModel(dto);

        return ResponseEntity.created(URI.create("")).build();
    }
}
