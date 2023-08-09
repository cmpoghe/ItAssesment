package com.its.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String fullNameEn;
	    private String fullNameAr;
	    private String email;
	    private String telephone;
	    private String address;
		public Student(Long id, String fullNameEn, String fullNameAr, String email, String telephone, String address) {
			super();
			this.id = id;
			this.fullNameEn = fullNameEn;
			this.fullNameAr = fullNameAr;
			this.email = email;
			this.telephone = telephone;
			this.address = address;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFullNameEn() {
			return fullNameEn;
		}
		public void setFullNameEn(String fullNameEn) {
			this.fullNameEn = fullNameEn;
		}
		public String getFullNameAr() {
			return fullNameAr;
		}
		public void setFullNameAr(String fullNameAr) {
			this.fullNameAr = fullNameAr;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	    
	    
}
