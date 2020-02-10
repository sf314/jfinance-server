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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.RestController; // For class

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    
    // ***** Vars 
    
    // ***** Endpoint for listing all 
    @GetMapping(
        value = "",
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
    
    // ***** Endpoint for listing accounts for a specific user
    @GetMapping(
        value = "/{name}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAccountsForUser(@PathVariable(value = "name") final String username) {
        ArrayList<String> accountList = new ArrayList<String>();
        
        // TODO: Business/data logic here: Should be objects with account metadata
        accountList.add("1"); 
        accountList.add("2");
        
        return new ResponseEntity<ArrayList<String>>(accountList, HttpStatus.OK);
    }
}