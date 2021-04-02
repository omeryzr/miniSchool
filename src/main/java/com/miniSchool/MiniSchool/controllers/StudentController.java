package com.miniSchool.MiniSchool.controllers;


import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> students(){
        return studentRepository.findAll();
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<Student> studentByGrade(@RequestParam int grade){
        return studentRepository.findByStudentGrade(grade);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student showStudentWithId(@PathVariable Long id){
        return studentRepository.getOne(id);
    }

}
