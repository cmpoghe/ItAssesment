package com.example.demo.mailUtility;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.JwtToken;
import com.example.demo.repository.JwtTokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenMnager {
	
	@Value("${demo.secret-key}")
	private String SecretKey; 

	
	@Value("${demo.token-expiry}")
	private Long tokenExpiryTime;
	
	@Autowired
	JwtTokenRepository JTRepo;
	
	public String getAccessToken(StudentDto SDto)
	{
	
	SignatureAlgorithm algorithm = SignatureAlgorithm.HS512;
	long nowMillis = System.currentTimeMillis();
	Date now = new Date(nowMillis);

	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecretKey);
	Key signKey = new SecretKeySpec(apiKeySecretBytes, algorithm.getJcaName());
	
	Map<String, Object> StudentDtoMap = new HashMap<>();
	StudentDtoMap.put("id",SDto.getId());
	StudentDtoMap.put("name", SDto.getName());
	StudentDtoMap.put("email_id",SDto.getEmail_id());
	StudentDtoMap.put("mobile_no",SDto.getMobile_no());
	StudentDtoMap.put("address", SDto.getAddress());
	
	JwtBuilder builder = Jwts.builder().claim("Students",StudentDtoMap ).setId(SDto.getId().toString()).setIssuedAt(now)
			.signWith(algorithm, signKey);
	if (tokenExpiryTime > 0) {
		long expMillis = nowMillis + tokenExpiryTime;
		Date expiry = new Date(expMillis);
		builder.setExpiration(expiry);
	}

	return builder.compact();
	}
	
	public StudentDto getStudentDto(String accessToken)
	{
	
		
		StudentDto Dto=null;
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SecretKey))
				.parseClaimsJws(accessToken).getBody();
		if (claims.containsKey("Students")) {
			ObjectMapper mapper = new ObjectMapper();
			Dto = mapper.convertValue(claims.get("Students", LinkedHashMap.class), StudentDto.class);
			
			JwtToken jwtToken = JTRepo.findByAccesTokenandId(accessToken, Dto.getId());
			if (jwtToken == null) {
				Dto = null;
			}
		}
		return Dto;
	}
	}
