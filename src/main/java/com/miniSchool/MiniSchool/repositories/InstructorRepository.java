package com.miniSchool.MiniSchool.repositories;

import com.miniSchool.MiniSchool.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
