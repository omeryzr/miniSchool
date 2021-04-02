package com.miniSchool.MiniSchool.controllers;


import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import com.miniSchool.MiniSchool.students.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PersistenceContext
    private EntityManager entityManager;

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
        System.out.println(id);
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

    @DeleteMapping("{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

}
