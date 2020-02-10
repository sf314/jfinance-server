package jfinance.resource;

import java.util.ArrayList;

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
    
    @GetMapping(
        value = "/{accountId}", 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AccountRO> getAccountInfo(@PathVariable("accountId") final String accountId) {
        System.out.println("Getting info for account " + accountId);
        
        AccountRO account = new AccountRO("abc123", "PA Main", 123.45);
        
        return new ResponseEntity<AccountRO>(account, HttpStatus.OK);
    }
}