package com.miniSchool.MiniSchool.repositories;

import com.miniSchool.MiniSchool.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
