package com.example.demo.service.Impl;



import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JwtTokenDto;
import com.example.demo.entity.JwtToken;
import com.example.demo.repository.JwtTokenRepository;
import com.example.demo.service.JwtTokenService;

@Service
public class JwtTokenServiceImpl implements JwtTokenService{

	
	@Autowired
	JwtTokenRepository JTrepo;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public JwtToken save(JwtToken jwtToken) {
		return JTrepo.save(jwtToken);
	}

	@Override
	public JwtTokenDto findByUserId(Long id) {
		Optional<JwtToken> jwtToken = JTrepo.findById(id);
		return modelMapper.map(jwtToken, JwtTokenDto.class);
	}

}
