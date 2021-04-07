package com.miniSchool.MiniSchool.services;

import com.miniSchool.MiniSchool.models.Student;
import com.miniSchool.MiniSchool.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Student> students(){
        return studentRepository.findAll();
    }

    public List<Student> studentByGrade(int grade){
        return studentRepository.findByStudentGrade(grade);
    }

    public Student showStudentWithId(Long id){
        return studentRepository.getOne(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
