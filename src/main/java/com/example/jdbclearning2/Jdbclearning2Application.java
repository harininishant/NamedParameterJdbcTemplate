package com.example.jdbclearning2;

import com.example.jdbclearning2.dao.StudentDao;
import com.example.jdbclearning2.domain.Student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Jdbclearning2Application {

//    private StudentDao dao;
//
//    public Jdbclearning2Application(StudentDao dao) {
//        this.dao = dao;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Jdbclearning2Application.class, args);
    }



}
