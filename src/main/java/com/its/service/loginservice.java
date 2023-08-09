package com.example.demo.service;

import com.example.demo.dto.loginformdto;
import com.example.demo.dto.updateLogindto;
import com.its.entity.Loginform;

public interface loginservice {
	Loginform getData(Loginform ldt);
	void savedata(loginformdto ldt);
	void updatepass(updateLogindto uld);
 
}
