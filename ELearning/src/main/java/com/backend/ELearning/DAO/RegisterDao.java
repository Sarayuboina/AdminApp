package com.backend.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.ELearning.Bean.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, Integer> {
//	@Query("Select a from register_info a where a.userName=(:name)")
	Register findRegisterByUserName(String userName);

}
