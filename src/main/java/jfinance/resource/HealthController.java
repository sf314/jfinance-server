package jfinance.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfinance.resource.ro.HealthRO;

@RestController
@RequestMapping("/health")
public class HealthController {
    
    @GetMapping("/liveness")
    public ResponseEntity<HealthRO> getLiveness() {
        return new ResponseEntity<HealthRO>(
            new HealthRO("Ok"), HttpStatus.OK
        );
    }
    
    @GetMapping("/readiness")
    public ResponseEntity<HealthRO> getReadiness() {
        return new ResponseEntity<HealthRO>(
            new HealthRO("Ok"), HttpStatus.OK
        );
    }
    
}