package com.backend.ELearning.Service;

import java.util.Map;

import com.backend.ELearning.Bean.Login;

public interface SecurityService {
	
	Map<String,String> getAuthToken(Login log);

}
