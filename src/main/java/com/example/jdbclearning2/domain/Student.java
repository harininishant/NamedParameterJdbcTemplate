package com.example.jdbclearning2.domain;


import lombok.*;

import java.util.Date;

//@Data
@Builder//(toBuilder = true)
@NoArgsConstructor //@NoArgsConstructor will generate a constructor with no parameters. and is needed for builder
@AllArgsConstructor // spring uses setter method hence default constructor is needed
@Setter
@Getter
public class Student { //POJO class
    private Integer id;
    private String firstName;
    private String lastName;
    private Date createDate;
    private Date updateDate; // Date is from java util
    private StudentStatus status;


}
