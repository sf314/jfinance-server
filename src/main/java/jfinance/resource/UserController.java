package jfinance.resource;

/**
 * UserInfo: RestController
 * Define endpoints for accessing user-level data
 * - list users
 * - list accounts for user
 */

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.RestController; // For class

import jfinance.data.FileStorage;
import jfinance.resource.ro.UserRO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
    
    // ***** Components
    @Autowired FileStorage fileStorage;
    
    // ***** Vars 
    public static final String CLASSNAME = UserController.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(CLASSNAME);
    
    // ***** Endpoint for listing all 
    @GetMapping(
        value = "",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<String>> getUsers() {
        try {
            List<String> userList = fileStorage.listItemsInDir("");
            return new ResponseEntity<List<String>>(userList, HttpStatus.OK);
        } catch (Exception e) {
            List<String> response = new ArrayList<>();
            response.add(e.getMessage());
            return new ResponseEntity<List<String>>(response, HttpStatus.OK);
        }
    }
    
    // ***** Endpoint for fetching information for a particular user
    @GetMapping(
        value = "/{userId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserRO> getInfoForUser(@PathVariable("userId") String userId) {
        final String METHOD = "getInfoForUser";
        UserRO user = new UserRO("Steve", 456);
        
        LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Fetched info for user " + userId + ": " + user.getName());
        return new ResponseEntity<UserRO>(user, HttpStatus.OK);
    }
    
    // ***** Endpoint for listing accounts for a specific user
    @GetMapping(
        value = "/{userId}/accounts",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<String>> getAccountsForUser(@PathVariable(value = "userId") final String userId) {
        try {
            List<String> userList = fileStorage.listItemsInDir(userId);
            return new ResponseEntity<List<String>>(userList, HttpStatus.OK);
        } catch (Exception e) {
            List<String> response = new ArrayList<>();
            response.add(e.getMessage());
            return new ResponseEntity<List<String>>(response, HttpStatus.OK);
        }
    }
    
    // ***** Endpoint for listing transactions for a given account
    @GetMapping(
        value = "/{userId}/accounts/{accountName}"
    )
    public ResponseEntity<List<String>> getTransactionsForAccount(
        @PathVariable(value = "userId") final String userId, 
        @PathVariable(value = "accountName") final String accountName) {

        try {
            List<String> userList = fileStorage.readTransactionsFromAccount(userId, accountName);
            return new ResponseEntity<List<String>>(userList, HttpStatus.OK);
        } catch (Exception e) {
            List<String> response = new ArrayList<>();
            response.add(e.getMessage());
            return new ResponseEntity<List<String>>(response, HttpStatus.OK);
        }
    }
    
    // ***** Endpoint for creating a new account for a user
    @PostMapping(
        value = "/{userId}/accounts/{accountName}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createNewAccountForUser(
        @PathVariable(value = "userId") final String userId, 
        @PathVariable(value = "accountName") final String accountName) {
        
        try {
            fileStorage.createAccountFile(userId, accountName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // ***** Endpoint for adding a transaction to an account
    @PutMapping(
        value = "/{userId}/accounts/{accountName}"
    )
    public ResponseEntity<Object> addTransaction(
        @PathVariable(value = "userId") final String userId, 
        @PathVariable(value = "accountName") final String accountName,
        @RequestBody String transactionLine) {
        
        try {
            fileStorage.writeStringToFile(userId, accountName, transactionLine);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}