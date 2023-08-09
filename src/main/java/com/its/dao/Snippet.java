package com.its.dao;

public class Snippet {
	@Query(value="select * from student_course where selected_course=?",nativeQuery = true)
		List<String> getStudent(String student_course);
		
		Optional<Strudent_courseEntity> findById(Long id);
}

