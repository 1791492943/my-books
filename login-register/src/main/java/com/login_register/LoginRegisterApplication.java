package com.login_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class    LoginRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginRegisterApplication.class,args);
    }

}
