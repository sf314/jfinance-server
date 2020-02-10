package jfinance.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

/**
 * Provides unit tests for the UserInfo resource class
 */
public class UserInfoTests {
    
    UserController userInfo;
    
    @Before
    public void before() {
        // Perform setup
        userInfo = new UserController();
    }
    
    @Test
    public void blank() {
        ResponseEntity<?> response = userInfo.getUsers();
        assertEquals(200, response.getStatusCodeValue());
    }
    
}