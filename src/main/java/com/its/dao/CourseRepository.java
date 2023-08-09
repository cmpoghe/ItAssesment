package com.its.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.its.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
	Optional<CourseEntity> findById(Long Id);

	@Query(value="select * from courses where course_name=?", nativeQuery = true)
	List<CourseEntity> getDetails(String course_name);
}
