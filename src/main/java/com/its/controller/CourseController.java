package com.its.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Headers;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.courseEntityDto;
import com.example.demo.dto.student_courseDto;
import com.example.demo.mailUtility.JwtTokenMnager;
import com.example.demo.repository.Student_courseRepository;
import com.example.demo.repository.courseEntityRepository;
import com.example.demo.service.StudentsService;
import com.example.demo.service.courseService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;




@CrossOrigin
@RestController
@RequestMapping("/courses")
public class courseController {
	@Autowired
	courseService CService;
	
	@Autowired
	courseEntityRepository CERepository;
	
	@Autowired
	StudentsService Sservice;
	
	@Autowired
	Student_courseRepository SCRepo;
	
	@Autowired
	JwtTokenMnager jToken;
	
	private Headers getHeader(HttpHeaders httpHeaders) {
		Headers header = new Headers();
		Map<String, String> headerMap = httpHeaders.toSingleValueMap();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return header;
	}
	
	@PostMapping("/saveCourses")
	void saveData (HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestBody courseEntityDto CEd)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.CService.saveData(CEd);
	}
	
	@PostMapping("/updateCourses")
	void update (HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestBody courseEntityDto CEd)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.CService.updateData(CEd);
	}

	@GetMapping("/getCourses")
	void getData(HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestParam(value="course_name")String course_name)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.CERepository.getDetails(course_name);
	}
	
	@DeleteMapping("/deleteData")
	void deleteData(HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestParam(value="id") Long id)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.CService.delete(id);
	}
	
	/***Students course***/
	
	@PostMapping("/SignUp")
	void SignUp (HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestBody StudentDto SDto)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.Sservice.signUp(SDto);
	}
	
	@PostMapping("/allocate_courses")
	void allocateCourses (HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestBody student_courseDto ScDto)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.Sservice.saveCourses(ScDto);
	}
	
	
	@GetMapping("/getStudent")
	void getStudents(HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestParam(value="selected_course") String selected_course)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.SCRepo.getStudent(selected_course);
	}
	
	@DeleteMapping("/delStudent")
	void deleteStudent(HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestParam(value="id") Long id)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.Sservice.deleteCourses(id);
	}
	@PostMapping("/updateStudents")
	void updateStudent(HttpServletResponse httpServletResponse,@RequestHeader(value = "accessToken") String accessToken,@RequestHeader HttpHeaders headers,@RequestBody student_courseDto ScDto)
	{
		Headers header = getHeader(headers);
		StudentDto stDto = jToken.getStudentDto(accessToken);
		this.Sservice.updateCourses(ScDto);
	}
}
