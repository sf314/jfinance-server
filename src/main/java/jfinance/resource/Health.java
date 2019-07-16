package jfinance.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health: RestController
 * Define endpoints for verifying health of the 
 * - list users
 * - list accounts for user
 */

 
@RestController
@RequestMapping("/health")
public class Health {
    
    // ***** Vars
    
    // ***** Check liveness
    @GetMapping(
        value = "/liveness",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getLiveness() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}