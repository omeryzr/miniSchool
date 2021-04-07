package com.miniSchool.MiniSchool.models;


import com.miniSchool.MiniSchool.repositories.LectureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LectureTest {
    @Autowired
    private LectureRepository lectureRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testSaveGetDelete(){
        Lecture lecture = new Lecture("math",4);
        lecture = lectureRepository.saveAndFlush(lecture);

        entityManager.clear();

        Lecture otherLecture = lectureRepository.getOne(lecture.getLectureId());
        assertEquals("math", otherLecture.getLectureName());

        lectureRepository.deleteById(otherLecture.getLectureId());
    }
}
