package jfinance.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheck {
    
    @GetMapping("/liveness")
    public ResponseEntity<?> getLiveness() {
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }
    
    @GetMapping("/readiness")
    public ResponseEntity<?> getReadiness() {
        return new ResponseEntity<String>("Ok", HttpStatus.OK);
    }
    
}