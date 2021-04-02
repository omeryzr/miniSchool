package com.miniSchool.MiniSchool.controllers;

import com.miniSchool.MiniSchool.models.Lecture;
import com.miniSchool.MiniSchool.repositories.LectureRepository;
import com.miniSchool.MiniSchool.services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lectures")
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<Lecture> lectures(){
        return lectureRepository.findAll();
    }
}
