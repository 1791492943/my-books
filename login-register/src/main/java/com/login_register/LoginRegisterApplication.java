package com.login_register;

import com.feign_api.client.SearchMysqlClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {SearchMysqlClient.class})
public class    LoginRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginRegisterApplication.class,args);
    }

}
