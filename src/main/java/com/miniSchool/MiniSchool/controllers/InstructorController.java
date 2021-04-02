package com.miniSchool.MiniSchool.controllers;

import com.miniSchool.MiniSchool.models.Instructor;
import com.miniSchool.MiniSchool.repositories.InstructorRepository;
import com.miniSchool.MiniSchool.students.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Instructor> instructors(){
        return instructorRepository.findAll();
    }

    @PostMapping
    public Instructor newInstructor(@RequestBody Instructor instructor){
        return instructorService.addNewInstructor(instructor);
    }

    @PutMapping("{id}")
    public Instructor update(@RequestBody Instructor instructor, @PathVariable Long id){
        return instructorService.updateInstructor(instructor, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        instructorRepository.deleteById(id);
    }

}
