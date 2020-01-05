package jfinance.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfinance.resource.ro.HealthRO;

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
    
    /**
     * Liveness check
     * @return
     */
    @GetMapping("/liveness")
    public ResponseEntity<HealthRO> getLiveness() {
        return new ResponseEntity<>(new HealthRO("ok"), HttpStatus.OK);
    }
    
    
    @GetMapping("/readiness")
    public ResponseEntity<HealthRO> getReadiness() {
        return new ResponseEntity<>(new HealthRO("ok"), HttpStatus.OK);
    }
}