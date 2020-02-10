package jfinance.resource.ro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRO {
    
    // ***** Variables
    @JsonProperty("id")
    String id;
    
    @JsonProperty("name")
    String name;
    
    @JsonProperty("balance")
    double balance;
    
    // ***** Constructors
    public AccountRO() {
        this.id = "0";
        this.name = "";
        this.balance = 0.0;
    }
    
    public AccountRO(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    
    // ***** Getters and setters
    public String getId() {
        return this.id;
    }
    
    public void setId(String newId) {
        this.id = newId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
    
}