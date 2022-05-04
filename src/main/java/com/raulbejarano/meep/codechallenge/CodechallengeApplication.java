package com.raulbejarano.meep.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CodechallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodechallengeApplication.class, args);
    }

}
