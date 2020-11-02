package org.note.function;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.note.function.mapper"})
public class OrgNoteFunctionApp {

    public static void main(String[] args) {
        SpringApplication.run(OrgNoteFunctionApp.class);
    }
}
