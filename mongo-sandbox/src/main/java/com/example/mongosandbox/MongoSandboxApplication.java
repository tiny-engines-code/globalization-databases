package com.example.mongosandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.mongosandbox")
public class MongoSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoSandboxApplication.class, args);
    }

}
