package jfinance.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfinance.resource.ro.HealthRO;

@RestController
@RequestMapping("/health")
public class HealthController {
    
    public static final String CLASSNAME = HealthController.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(CLASSNAME);
    
    @GetMapping("/liveness")
    public ResponseEntity<HealthRO> getLiveness() {
        LOGGER.logp(Level.INFO, CLASSNAME, "getLiveness", "Liveness endpoint triggered");
        return new ResponseEntity<HealthRO>(
            new HealthRO("Ok"), HttpStatus.OK
        );
    }
    
    @GetMapping("/readiness")
    public ResponseEntity<HealthRO> getReadiness() {
        LOGGER.logp(Level.INFO, CLASSNAME, "getReadiness", "Readiness endpoint triggered");
        return new ResponseEntity<HealthRO>(
            new HealthRO("Ok"), HttpStatus.OK
        );
    }
    
}