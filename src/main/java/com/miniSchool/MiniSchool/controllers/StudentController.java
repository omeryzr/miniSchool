package com.miniSchool.MiniSchool.controllers;


import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import com.miniSchool.MiniSchool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> students(Student student){
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

    @PostMapping
    public Student newStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return student;
    }

    //A different method to delete
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody*/

    @PutMapping("{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student, id);
        return student;
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        studentRepository.deleteById(id);
    }
}
