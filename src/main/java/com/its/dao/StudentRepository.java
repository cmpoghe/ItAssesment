package com.its.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.its.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}