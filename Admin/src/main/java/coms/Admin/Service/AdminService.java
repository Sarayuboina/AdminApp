package coms.Admin.Service;


import java.util.List;

import coms.Admin.bean.Grades;

public interface AdminService {

	Grades insertGrade(String gradName);

	List<Grades> grades();

	Grades updateGrad(String gradName,String newGrad);

	void deleteGrade(String gradName);

}
