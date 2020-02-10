package jfinance.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfinance.resource.ro.AccountRO;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    // ***** Variables
    public static final String CLASSNAME = AccountController.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(CLASSNAME);
    
    @GetMapping(
        value = "/{accountId}", 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AccountRO> getAccountInfo(@PathVariable("accountId") final String accountId) {
        final String METHOD = "getAccountInfo";
        
        AccountRO account = new AccountRO("abc123", "PA Main", 123.45);
        
        LOGGER.logp(Level.INFO, CLASSNAME, METHOD, "Fetched account " + accountId + ": " + account.getName());
        return new ResponseEntity<AccountRO>(account, HttpStatus.OK);
    }
}