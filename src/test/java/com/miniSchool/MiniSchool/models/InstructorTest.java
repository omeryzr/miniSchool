package com.miniSchool.MiniSchool.models;

import com.miniSchool.MiniSchool.repositories.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InstructorTest {
    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception{
        Instructor instructor = new Instructor("Kemalettin", "Yazir");
        instructor = instructorRepository.saveAndFlush(instructor);

        entityManager.clear();

        Instructor otherInstructor = instructorRepository.getOne(instructor.getInstructorId());
        assertEquals("Kemalettin", otherInstructor.getInstructorFirstName());

        instructorRepository.deleteById(otherInstructor.getInstructorId());
    }
}
