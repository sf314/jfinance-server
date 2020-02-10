package jfinance.resource.ro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthRO {
    
    // ***** Variables 
    @JsonProperty("status")
    String status;
    
    // ***** Constructor 
    public HealthRO(String status) {
        this.status = status;
    }
}