package com.backend.ELearning.Service;

import org.springframework.stereotype.Service;

import com.backend.ELearning.Bean.Login;
import com.backend.ELearning.Bean.Register;

@Service
public interface MainService {
	
	public Login signIn(String userName,String pass);
	public Register signUp(Register reg);
	public Register checkUser(String userName);
	public void saveLog(String userName, String pass);
	public int getRole(String userName);
	public Register updatePass(Register reg, Login log);

}
