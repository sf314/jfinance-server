package jfinance.resource.ro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRO {
    
    // ***** Variables
    @JsonProperty("name")
    String name;
    
    @JsonProperty("id")
    long id;
    
    // ***** Constructors
    public UserRO(String name, long id) {
        this.name = name;
        this.id = id;
    }
}