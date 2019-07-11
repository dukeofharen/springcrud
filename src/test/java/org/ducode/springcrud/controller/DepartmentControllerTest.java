package org.ducode.springcrud.controller;

import org.ducode.springcrud.config.WebConfig;
import org.ducode.springcrud.dto.DepartmentDto;
import org.ducode.springcrud.exception.CustomExceptionHandler;
import org.ducode.springcrud.models.Department;
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

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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

    @Before
    public void setUp() throws Exception {
        departmentTransformer = mock(DepartmentTransformer.class);
        departmentController = new DepartmentController(departmentTransformer);
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController)
                .setControllerAdvice(new CustomExceptionHandler())
                .build();
    }

    @Test
    public void getDepartment() throws Exception {
        Department department = new Department("test");
        departmentController.departments.add(department);
        when(departmentTransformer.toDto(department)).thenReturn(new DepartmentDto(department.getName()));

        mockMvc.perform(get("/api/department"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(department.getName())));
    }

    @Test
    public void createDepartment() throws Exception {
        String name = "administration";
        when(departmentTransformer.toModel(any(DepartmentDto.class))).thenReturn(new Department(name));

        mockMvc.perform(post("/api/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \""+name+"\"}"))
                .andExpect(status().isCreated());

        assertEquals(1, departmentController.departments.size());
    }

    @Test
    public void createDepartmentInvalidName() throws Exception {
        String name = "illegalDep";

        mockMvc.perform(post("/api/department")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \""+name+"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("This name is not valid.")));
    }
}