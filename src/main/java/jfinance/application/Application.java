package jfinance.application;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableAutoConfiguration
@ComponentScan({
    "jfinance.resource",
    "jfinance.business",
    "jfinance.data"
})
public class Application {
    public static void main(String[] args) {
        System.out.println("Started application");
        
        SpringApplication.run(Application.class, args);
    }
}