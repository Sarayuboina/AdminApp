package com.backend.ELearning;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.backend.ELearning.Bean.Register;
import com.backend.ELearning.DAO.RegisterDao;
import com.backend.ELearning.Service.MainServiceImp;

@DataMongoTest
@ExtendWith(MockitoExtension.class)
public class UserService {
	

    @Mock
    private RegisterDao registerDao;

    @InjectMocks
    private MainServiceImp mainService;
    private  Register user1, user2;
    List<Register> user;
    
    @BeforeEach
    public void setUp() {

        user1 = new Register( "ABCD", "XYZZ" , "abc.xyz@gmail.com", "AbcXyz",2);
        user2 = new Register( "John", "Paul" , "john.paul@gmail.com", "John@Paul123",3);


        
    }

    @AfterEach
    public void tearDown() {
       registerDao.deleteAll();
       user1 = null;
        user2 = null;

    }
    
    @Test
    public void givenUserToSaveReturnSavedUserSuccess() {
        when(mainService.signUp(any())).thenReturn(user1);
        assertEquals(user1, mainService.signUp(user1));
        verify(registerDao, times(1)).save(any());

    }


}
