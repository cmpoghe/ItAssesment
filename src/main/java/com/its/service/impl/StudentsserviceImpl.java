package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.student_courseDto;
import com.example.demo.entity.Strudent_courseEntity;
import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.Student_courseRepository;
import com.example.demo.service.StudentsService;


@Service
public class StudentsserviceImpl implements StudentsService{
	
	@Autowired
	Student_courseRepository scRepo;
	
	@Autowired
	StudentRepository SRepo;

	@Override
	public void saveCourses(student_courseDto ScDto) {
		Strudent_courseEntity students = new Strudent_courseEntity(0l,ScDto.getStudent_name(),ScDto.getArabicName(),ScDto.getSelected_course());
		this.scRepo.save(students);
		
	}

	@Override
	public void updateCourses(student_courseDto ScDto) {
		Strudent_courseEntity students = new Strudent_courseEntity(ScDto.getId(),ScDto.getStudent_name(),ScDto.getArabicName(),ScDto.getSelected_course());
		this.scRepo.save(students);
		
	}

	@Override
	public void deleteCourses(Long id) { 
		Optional<Strudent_courseEntity> delcourses = scRepo.findById(id);
		scRepo.delete(delcourses.get());
	}

	@Override
	public void signUp(StudentDto SDto) {
		Students students = new Students(0l,SDto.getName(),SDto.getArabicName(),SDto.getEmail_id(),SDto.getMobile_no(),SDto.getAddress());
		this.SRepo.save(students);
		
	}
	

}
