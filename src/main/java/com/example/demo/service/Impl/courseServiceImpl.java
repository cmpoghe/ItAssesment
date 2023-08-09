package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.courseEntityDto;
import com.example.demo.entity.courseEntity;
import com.example.demo.repository.courseEntityRepository;
import com.example.demo.service.courseService;


@Service
public class courseServiceImpl implements courseService{
	
	@Autowired
	courseEntityRepository CERepository;

	@Override
	public void saveData(courseEntityDto Ced) {
		courseEntity courseentity = new courseEntity(0l,Ced.getCourse_name(),Ced.getCourse_detail());
		this.CERepository.save(courseentity);
	}

	@Override
	public void updateData(courseEntityDto Ced) {
		courseEntity courseentity = new courseEntity(Ced.getId(),Ced.getCourse_name(),Ced.getCourse_detail());
		this.CERepository.save(courseentity);
		
	}

	@Override
	public void delete(Long id) {
		Optional<courseEntity> deldata = CERepository.findById(id);
		CERepository.delete(deldata.get());
		
	}

	@Override
	public courseEntity getData(courseEntity courseentity) {
		CERepository.save(courseentity);
		return courseentity;
		
	}

}
