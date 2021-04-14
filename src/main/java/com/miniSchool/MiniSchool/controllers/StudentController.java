package com.miniSchool.MiniSchool.controllers;


import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import com.miniSchool.MiniSchool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Student> students(){
        return studentService.students();
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<Student> studentByGrade(@RequestParam int grade){
        return studentService.studentByGrade(grade);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Student showStudentWithId(@PathVariable Long id){
        return studentService.showStudentWithId(id);
    }

    @PostMapping
    public ResponseEntity<String> newStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Created a student named " + student.getFirstName());
    }

    //A different method to delete
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody*/

    @PutMapping("{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatus.OK).body("Updated Student: " + student.getFirstName());
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteStudent(@PathVariable Long id){
       studentService.deleteStudent(id);
    }
}
