package com.yph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

/**
 * @author Agu
 */
@SpringBootApplication
public class AppUser {

    public static void main(String[] args) {

//        BigDecimal bigDecimal = new BigDecimal("10");
//        bigDecimal = bigDecimal.add(new BigDecimal("1.111"));
//        System.out.println(bigDecimal);

        SpringApplication.run(AppUser.class);
    }
}
