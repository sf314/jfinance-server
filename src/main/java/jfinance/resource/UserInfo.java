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
import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.RequestParam; // For uri params
import org.springframework.web.bind.annotation.RestController; // For class

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserInfo {
    
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
    public ResponseEntity<?> getAccountsForUser(@RequestParam(value = "name") final String username) {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}