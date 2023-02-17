package com.backend.ELearning.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ELearning.Bean.Login;
import com.backend.ELearning.Bean.Register;
import com.backend.ELearning.Service.MainService;
import com.backend.ELearning.Service.SecurityService;

@RestController
@RequestMapping("/elearning/api")
@CrossOrigin(origins="*")

public class MainController {
	
	@Autowired
	MainService ms;
	
	@Autowired
	SecurityService securityService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> Signin(@RequestBody Login log) throws Exception{
		System.out.print(log.getUserName()+","+log.getPass());
		
		Login res=ms.signIn(log.getUserName(),log.getPass());
		System.out.print(res.getUserName()+","+res.getPass());
		if(res!=null) {
			 Map<String, String> tokenMap = securityService.getAuthToken(res);
			 int role=ms.getRole(log.userName);
			 return ResponseEntity.status(HttpStatus.OK).body(tokenMap);
		}		
		throw new Exception("Invalid user credentials....");
		
	}
	
//	@PostMapping("/login")
//public Login Signin(@RequestBody Login log) throws Exception{
//		
//	Login res=ms.signIn(log.getUserName(),log.getPass());
//		if(res!=null) {
//			 			 return res;
//	}		
//		throw new Exception("Invalid user credentials....");
//		}
	
	
	@PostMapping("/signup")
	public Register Signup(@RequestBody Register reg) throws Exception {
		System.out.print(reg.getUserName());
		Register res=ms.checkUser(reg.getUserName());
		if(res==null) {
			ms.saveLog(reg.getUserName(),reg.getPass());
			return ms.signUp(reg);
			
		}
		throw new Exception("This user already exists...");
		
	}
	
	
	
	@PostMapping()
	public Register SignUp(@RequestBody Register reg) throws Exception {
		
		
			return ms.signUp(reg);
			
		
//		throw new Exception("This user already exists...");
		
	}
	
	@PostMapping("/user/{userName}")
	public Register userData(@PathVariable String userName) throws Exception {
	System.out.print(userName);
		Register res=ms.checkUser(userName);
		return res;
		
	}
	
	@PutMapping("/change/{userName}")
	public Register resetPass(@PathVariable String userName,@RequestBody String npass) throws Exception {
	
		Register res=ms.checkUser(userName);
		Login log=ms.signIn(userName,res.getPass());
		log.setPass(npass);
		res.setPass(npass);
		Register reg=ms.updatePass(res,log);
		return reg;
		
	}
	
	


}
