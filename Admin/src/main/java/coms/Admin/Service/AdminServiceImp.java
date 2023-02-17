package coms.Admin.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.Admin.DAO.GradeDao;
import coms.Admin.DAO.SubjectDao;
import coms.Admin.bean.Grades;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired SubjectDao subDao;
	@Autowired GradeDao gradDao;
	@Override
	public Grades insertGrade(String gradName) {
		// TODO Auto-generated method stub
		boolean b=gradDao.existsByGradName(gradName);
		if(b==true) {
		   Grades grad=new Grades(gradName);
		   return gradDao.save(grad);
		}
		else {
		
		return null;
	}
	
	
	
	

}
	@Override
	public List<Grades> grades() {
		// TODO Auto-generated method stub
		
		
		return gradDao.findAll();
	}
	@Override
	public Grades updateGrad(String gradName,String newGrad) {
		// TODO Auto-generated method stub
		Grades grad=gradDao.findByGradName(gradName);
		grad.setGradName(newGrad);
		return gradDao.saveAndFlush(grad);
	}
	@Override
	public void deleteGrade(String gradName) {
		// TODO Auto-generated method stub
		
		gradDao.deleteByGradName(gradName);
		
	}
}
