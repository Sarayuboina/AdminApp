package com.backend.ELearning.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_info")
public class Register {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int regId;
    public String firstName;
    public String lastName;
    public String userName;
    public String pass;
    public int role;
    
    
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Register(int regId, String firstName, String lastName, String userName, String pass, int role) {
		super();
		this.regId = regId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.pass = pass;
		this.role = role;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(String firstName, String lastName, String userName, String pass, int role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.pass = pass;
		this.role = role;
	}
    
    
    
    
}
