package com.example.demo.dto;

import com.example.demo.entity.Students;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private Long id;
	private String name;
	private String arabicName;
	private String email_id;
	private String mobile_no;
	private String  Address;
}
