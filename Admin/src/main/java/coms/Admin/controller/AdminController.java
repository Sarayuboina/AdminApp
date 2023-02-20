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
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/addGrades/{userName}")
	public ResponseEntity<Grades> addGrad(@RequestBody Grades grad){
		
		Grades res=adminService.insertGrade(grad.getGradName());
		if(res!= null) {
			return new ResponseEntity<Grades>(res,HttpStatus.OK);
		}
		return new ResponseEntity<Grades>(res,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/getGrades/{userName}")
	public List<Grades> getGrade() throws Exception{
		
		List<Grades> res=adminService.grades();
		
		if(res==null) {
			throw new Exception("Empty!!");
			
		}
		return res;
		
	}
	
	@PatchMapping("/editGrad/{userName}/{gradId}")
	public ResponseEntity<Grades> editGrade(@RequestBody String gradName,@PathVariable Integer gradId){
		
		Grades res=adminService.updateGrad(gradName,gradId);
		
		
		if(res!=null) {
			return new ResponseEntity<Grades>(res,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@DeleteMapping("/deleteGrad/{userName}/{gradId}")
	public String deleteGrade(@PathVariable Integer gradId){
		
		adminService.deleteGrade(gradId);
		return "Success";
		
		
		
	}
	

}
