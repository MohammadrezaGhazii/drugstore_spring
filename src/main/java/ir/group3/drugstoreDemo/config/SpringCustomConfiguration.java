package ir.group3.drugstoreDemo.config;

import org.passay.PasswordGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCustomConfiguration {

    @Bean
    public PasswordGenerator passwordGenerator(){
        return new PasswordGenerator();
    }
}
