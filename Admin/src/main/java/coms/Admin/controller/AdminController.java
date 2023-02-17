package coms.Admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coms.Admin.Service.AdminService;
import coms.Admin.bean.Grades;

@RestController
@RequestMapping("/elearning/api/admin")
@CrossOrigin(origins="*")
public class AdminController {
	
	@Autowired AdminService adminService;
	
	@PostMapping("/addGrade")
	public ResponseEntity<Grades> addGrad(@RequestBody String gradName){
		
		Grades res=adminService.insertGrade(gradName);
		if(res!= null) {
			return new ResponseEntity<Grades>(res,HttpStatus.OK);
		}
		return new ResponseEntity<Grades>(res,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/getGrades")
	public ResponseEntity<List<Grades>> getGrade(){
		
		List<Grades> res=new ArrayList<>();
		res=adminService.grades();
		if(res!=null) {
			return new ResponseEntity<List<Grades>>(res,HttpStatus.FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PatchMapping("/editGrad")
	public ResponseEntity<Grades> editGrade(@RequestBody String gradName,String newGrad){
		
		Grades res=adminService.updateGrad(gradName,newGrad);
		
		
		if(res!=null) {
			return new ResponseEntity<Grades>(res,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@DeleteMapping("/deleteGrad")
	public ResponseEntity<?> deleteGrade(@RequestBody String gradName){
		
		adminService.deleteGrade(gradName);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
		
	}
	

}
