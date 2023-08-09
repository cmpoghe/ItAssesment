package com.example.demo.service;

import com.example.demo.entity.JwtToken;
import com.its.dto.JwtTokenDto;

public interface JwtTokenService {
	JwtToken save(JwtToken JwtToken);

	JwtTokenDto findByUserId(Long id);

}
