package jfinance;

import org.springframework.web.bind.annotation.RequestMapping; // For endpoints
import org.springframework.web.bind.annotation.RequestParam; // For uri params
import org.springframework.web.bind.annotation.RestController; // For class


@RestController
public class ResourceController {
    // Vars here
    private String greeting = "Hello";
    
    @RequestMapping("/getResource")
    public TestResource getResource(@RequestParam(value="name", defaultValue="Sir") String name) {
        System.out.println("Hit URI `/getResource`");
        TestResource resource = new TestResource();
        resource.setName(name);
        resource.setId(12);
        
        return resource;
    }
    
    // @RequestMapping("/error") // Apparently, avoid manually mapping /error for some reason
    // public String throwError() {
    //     System.out.println("Oops! Something went wrong!");
    //     return "Found an error";
    // }
    
    // @RequestMapping("/addAccount")
    
}