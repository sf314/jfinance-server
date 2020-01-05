package jfinance.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController; // For class

import jfinance.business.TestResource;

@RestController
@RequestMapping("/getResource")
public class ResourceController {
    
    @RequestMapping("/{name}")
    public ResponseEntity<?> getResource(@PathVariable(value="name") String name) {
        System.out.println("Hit URI `/getResource`");
        TestResource resource = new TestResource();
        resource.setName(name);
        resource.setId(12);
        
        return new ResponseEntity<TestResource>(resource, HttpStatus.OK);
    }
}