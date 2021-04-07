package com.miniSchool.MiniSchool.models;


import com.miniSchool.MiniSchool.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Student student = new Student("Omer", "Yazir", 3);
        student = studentRepository.saveAndFlush(student);

        entityManager.clear();

        Student otherStudent = studentRepository.getOne(student.getStudentId());
        assertEquals("Omer", otherStudent.getFirstName());

        studentRepository.deleteById(otherStudent.getStudentId());
    }

}
