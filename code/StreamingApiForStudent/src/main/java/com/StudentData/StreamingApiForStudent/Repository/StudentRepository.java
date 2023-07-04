package com.StudentData.StreamingApiForStudent.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentData.StreamingApiForStudent.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
