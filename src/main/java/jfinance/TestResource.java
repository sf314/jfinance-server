// Simple POJO for modelling stuff

package jfinance;


public class TestResource {
    // Members
    private String name;
    private int id;
    
    public TestResource() {
        System.out.println("Creating new TestResource");
        this.name = "Name";
        this.id = 0;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void setId(int i) {
        this.id = i;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id;
    }
}