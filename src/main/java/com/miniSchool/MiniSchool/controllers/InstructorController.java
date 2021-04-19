package com.miniSchool.MiniSchool.controllers;

import com.miniSchool.MiniSchool.models.Instructor;
import com.miniSchool.MiniSchool.repositories.InstructorRepository;
import com.miniSchool.MiniSchool.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> instructors(){
        return ResponseEntity.status(HttpStatus.OK).body(instructorRepository.findAll());
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(instructorRepository.getOne(id));
    }

    @PostMapping
    public ResponseEntity<String> newInstructor(@RequestBody Instructor instructor){
        return ResponseEntity.status(HttpStatus.OK).body("Created a User named: " + instructor.getInstructorFirstName());
    }

    @PutMapping("{id}")
    public ResponseEntity<Instructor> update(@RequestBody Instructor instructor, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.updateInstructor(instructor, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }

}
