package com.backend.ELearning.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_info")

public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int loginId;
	public String userName;
	public String pass;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Login(int loginId, String userName, String pass) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.pass = pass;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String userName, String pass) {
		// TODO Auto-generated constructor stub
		this.userName=userName;
		this.pass=pass;
	}
	
	
	

}
