package jfinance.resource;

/**
 * UserInfo: RestController
 * Define endpoints for accessing user-level data
 * - list users
 * - list accounts for user
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.RequestParam; // For uri params
import org.springframework.web.bind.annotation.RestController; // For class

import java.util.ArrayList;

@RestController
public class UserInfo {
    
    // ***** Vars 
    
    
    // ***** Users endpoint for listing current users
    @RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUsers() {
        ArrayList<String> userList = new ArrayList<String>();
        
        // TODO: Business/data logic here
        userList.add("bob");
        userList.add("steve");
        
        if (userList.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return new ResponseEntity<ArrayList<String>>(userList, HttpStatus.OK);
    }
    
    
}