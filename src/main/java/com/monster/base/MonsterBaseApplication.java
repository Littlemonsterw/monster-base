package com.monster.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.monster.base.**.mapper.**"})
public class MonsterBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonsterBaseApplication.class, args);
    }

}
