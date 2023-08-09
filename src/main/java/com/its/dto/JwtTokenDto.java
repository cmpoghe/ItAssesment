package com.example.demo.dto;

public class JwtTokenDto {
	private String accessToken;

	public JwtTokenDto() {
		// TODO Auto-generated constructor stub
	}

	public JwtTokenDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


}
