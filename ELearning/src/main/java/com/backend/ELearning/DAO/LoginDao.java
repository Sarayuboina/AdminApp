package com.backend.ELearning.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ELearning.Bean.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer> {

	Login findLoginByUserNameAndPass(String userName, String pass);

}
