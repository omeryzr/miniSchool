package com.miniSchool.MiniSchool.students;

import com.miniSchool.MiniSchool.models.Instructor;
import com.miniSchool.MiniSchool.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    public Instructor addNewInstructor(Instructor instructor){
        instructor.setInstructorFirstName(instructor.getInstructorFirstName());
        instructor.setInstructorLastName(instructor.getInstructorLastName());
        return instructorRepository.saveAndFlush(instructor);
    }

    public Instructor updateInstructor(Instructor instructor, Long id){
        instructor.setInstructorId(id);
        instructor.setInstructorFirstName(instructor.getInstructorFirstName());
        instructor.setInstructorLastName(instructor.getInstructorLastName());
        return instructorRepository.saveAndFlush(instructor);
    }
}
