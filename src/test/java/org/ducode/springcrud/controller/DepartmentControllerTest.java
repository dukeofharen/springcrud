package org.ducode.springcrud.controller;

import org.ducode.springcrud.config.WebConfig;
import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.exception.CustomExceptionHandler;
import org.ducode.springcrud.models.Department;
import org.ducode.springcrud.service.DepartmentService;
import org.ducode.springcrud.transformer.DepartmentTransformer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class DepartmentControllerTest {

    private MockMvc mockMvc;

    private DepartmentController departmentController;

    private DepartmentTransformer departmentTransformer;

    private DepartmentService departmentService;

    @Before
    public void setUp() throws Exception {
        departmentTransformer = mock(DepartmentTransformer.class);
        departmentService = mock(DepartmentService.class);
        departmentController = new DepartmentController(departmentTransformer, departmentService);
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController)
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Test
    public void getDepartment() throws Exception {
        Department department = new Department("test");
        when(departmentService.getDepartments()).thenReturn(Collections.singletonList(department));
        when(departmentTransformer.toDto(department)).thenReturn(new DepartmentDto(department.getName()));

        mockMvc.perform(get("/api/department"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(department.getName())));
    }

    @Test
    public void createDepartment() throws Exception {
        String name = "administration";
        Department department = new Department(name);
        when(departmentTransformer.toModel(any(DepartmentDto.class))).thenReturn(department);

        mockMvc.perform(post("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \""+name+"\"}"))
                .andExpect(status().isCreated());

        verify(departmentService).createDepartment(department);
    }
}