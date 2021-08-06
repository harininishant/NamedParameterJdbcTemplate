package com.example.jdbclearning2.dao;

import com.example.jdbclearning2.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDao {


    JdbcTemplate template;// from spring connecting to local host sql database
    /*
    Spring JdbcTemplate is a powerful mechanism to connect to the
    database and execute SQL queries. It internally uses JDBC api,
     but eliminates a lot of problems of JDBC API.
     */

    public StudentDao(JdbcTemplate template) {
        this.template = template;
    }

    public Student createStudent(Student student){
        student.setId(((int) Math.floor(Math.random() * 1000000)));
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
        template.update(sql,student.getId(),student.getFirstName(),student.getLastName(),student.getCreateDate(),
                student.getUpdateDate(),student.getStatus().toString());
        return student;


    }// new method of creating table using java
            public  void  createTable(){
      String sql = "CREATE TABLE COURSE(ID int, NAME VARCHAR(255),DESC VARCHAR(500))";
      StatementCallback <Object> statementCallback = statement -> statement.execute(sql);
      //template.execute(sql);// this is one of execution by witing in controll as well.
                template.execute(statementCallback);


}

    public List<Student> getAllStudent(){ //  THIS METHOD  PreparedStatementCreator CALLS ALL STUDENTS NAME THAT STARTS WITH HEMA
        String sql = "SELECT * FROM STUDENT WHERE FIRST_NAME LIKE  ? ";
        //return template.query(sql,new Object[]{"HEMA"},new int[]{1},new BeanPropertyRowMapper<>(Student.class));
        //System.out.println("this method is for creating all students");
        PreparedStatementCreator statementCreator= connection -> connection.prepareStatement(sql);
        return template.query(statementCreator,new BeanPropertyRowMapper<>(Student.class));

    }
    public  Student getStudentById(int id){
        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = ? ",
                new BeanPropertyRowMapper<>(Student.class),id);

    }

         public  int getStudentCount(){ // it counted the students and gave output as 3.// used queryForObject
        return template.queryForObject("SELECT count(0) FROM STUDENT",Integer.class);
}


}
