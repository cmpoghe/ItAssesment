package com.example.demo.dto;

import com.example.demo.entity.Strudent_courseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student_courseDto {
	private Long id;
	private String student_name;
	private String arabicName;
	private String selected_course;
	
}
