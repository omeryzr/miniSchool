package com.miniSchool.MiniSchool.repositories;

import com.miniSchool.MiniSchool.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
