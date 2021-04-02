package com.miniSchool.MiniSchool.services;

import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addNewStudent(Student student){
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setStudentGrade(student.getStudentGrade());
        return studentRepository.saveAndFlush(student);
    }

    public Student updateStudent(Student student, Long id){
        student.setStudentId(id);
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        student.setStudentGrade(student.getStudentGrade());
        return studentRepository.saveAndFlush(student);
    }
}
