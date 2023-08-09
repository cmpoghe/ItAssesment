package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ms_jwttoken")
@Getter
@Setter
@ToString
public class JwtToken {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ms_id")
	private Long id;

	@Column(name = "ms_accesstoken", length = 3000)
	private String accessToken;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false, unique = true)
	private Strudent_courseEntity students;

	public JwtToken() {
		// TODO Auto-generated constructor stub
	}

	public JwtToken(String accessToken, Strudent_courseEntity students) {
		super();
		this.accessToken = accessToken;
		this.students = students;
	}

}
