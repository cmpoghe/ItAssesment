package com.example.demo.service;

import com.its.dto.StudentDto;
import com.its.dto.student_courseDto;

public interface StudentsService {
	void saveCourses(student_courseDto ScDto);
	void updateCourses(student_courseDto ScDto);
	void deleteCourses(Long id);
	void signUp(StudentDto SDto);

}
