package com.nru.mytb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyTbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTbApplication.class, args);
    }

}
