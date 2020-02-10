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

import jfinance.resource.ro.AccountRO;
import jfinance.resource.ro.UserRO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    
    // ***** Vars 
    public static final String CLASSNAME = UserController.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(CLASSNAME);
    
    // ***** Endpoint for listing all 
    @GetMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ArrayList<UserRO>> getUsers() {
        final String METHOD = "getUsers";
        
        ArrayList<UserRO> userList = new ArrayList<UserRO>();
        
        // TODO: Business/data logic here
        userList.add(new UserRO("Geoff", 123));
        userList.add(new UserRO("Steve", 456));
        
        LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Number of users found: " + userList.size());
        
        if (userList.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return new ResponseEntity<ArrayList<UserRO>>(userList, HttpStatus.OK);
    }
    
    // ***** Endpoint for fetching information for a particular user
    @GetMapping(
        value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserRO> getInfoForUser(@PathVariable("id") String id) {
        final String METHOD = "getInfoForUser";
        UserRO user = new UserRO("Steve", 456);
        
        LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Fetched info for user " + id + ": " + user.getName());
        return new ResponseEntity<UserRO>(user, HttpStatus.OK);
    }
    
    // ***** Endpoint for listing accounts for a specific user
    @GetMapping(
        value = "/{id}/accounts",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ArrayList<AccountRO>> getAccountsForUser(@PathVariable(value = "id") final String userId) {
        final String METHOD = "getAccountsForUser";
        ArrayList<AccountRO> accountList = new ArrayList<AccountRO>();
        
        // TODO: Business/data logic here: Should be objects with account metadata
        accountList.add(new AccountRO("abc123", "PA Main", 123.45)); 
        accountList.add(new AccountRO("def456", "SA Main", 678.90));
        
        LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "User " + userId + " has " + accountList.size() + " accounts");
        
        return new ResponseEntity<ArrayList<AccountRO>>(accountList, HttpStatus.OK);
    }
}