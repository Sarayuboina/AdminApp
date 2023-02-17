package com.backend.ELearning.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ELearning.Bean.Login;
import com.backend.ELearning.Bean.Register;
import com.backend.ELearning.DAO.LoginDao;
import com.backend.ELearning.DAO.RegisterDao;

@Service
public class MainServiceImp implements MainService {
	
	@Autowired 
	LoginDao lg;
	@Autowired 
	RegisterDao rg;

	@Override
	public Login signIn(String userName, String pass) {
		// TODO Auto-generated method stub
		
		
		return lg.findLoginByUserNameAndPass(userName,pass);
	}

	@Override
	public Register signUp(Register reg) {
		// TODO Auto-generated method stub
		
		return rg.save(reg) ;
		
	}

	@Override
	public Register checkUser(String userName) {
		// TODO Auto-generated method stub
		Register res=rg.findRegisterByUserName(userName);
		
		return res;
		
	}

	@Override
	public void saveLog(String userName, String pass) {
		// TODO Auto-generated method stub
		Login log=new Login(userName,pass);
	
		lg.save(log);
		
	}

	@Override
	public int getRole(String userName) {
		// TODO Auto-generated method stub
		
		Register res= rg.findRegisterByUserName(userName);
		return res.role;
	}

	@Override
	public Register updatePass(Register reg,Login log) {
		// TODO Auto-generated method stub
		lg.saveAndFlush(log);
	   return rg.saveAndFlush(reg);
	   
		
	}

}
