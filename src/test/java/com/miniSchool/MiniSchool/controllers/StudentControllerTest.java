package com.miniSchool.MiniSchool.controllers;

import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import com.miniSchool.MiniSchool.services.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Should list all students when making get request to endpoint - /api/v1/students/")
    public void shouldListAllStudents() throws Exception {
        Student student = new Student((long) 1, "omerTest", "yazirTest", 3);
        Student student1 = new Student((long) 2, "omerTest1", "yazirTest1", 3);

        Mockito.when(studentService.students()).thenReturn(Arrays.asList(student, student1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName", Matchers.is("omerTest")));
    }

    @Test
    public void testShowStudentById() throws Exception{
        Student student = new Student((long) 1,"omerTest", "yazirTest", 3);
        Student student1 = new Student((long) 2, "omerTest1", "yazirTest1", 3);

        Mockito
                .when(studentService.showStudentWithId(student.getStudentId()))
                .thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students/" + student.getStudentId()))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

}