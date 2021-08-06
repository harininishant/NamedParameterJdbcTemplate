package com.example.jdbclearning2.dao;

import com.example.jdbclearning2.domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
@Repository
public class NewStudentDao {

    private NamedParameterJdbcTemplate template;// we can mention the parameters instead of ?,?

    public NewStudentDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Student createStudent(Student student){
        student.setId(((int) Math.floor(Math.random() * 1000000)));
        String sql = "INSERT INTO STUDENT VALUES(:id,:firstName,:lastName,:createDate,:updateDate,:status)";
        template.update(sql,new BeanPropertySqlParameterSource(student));
                return student;


    }
    public  Student getStudentById(int id) {
        return template.queryForObject("SELECT * FROM STUDENT WHERE ID = :id ", Collections.singletonMap("id", id), new BeanPropertyRowMapper<>(Student.class));

    }

    public int updateLastName(Student student){
        String sql = "UPDATE STUDENT SET LAST_NAME =:LAST_NAME WHERE ID= :id";
        return template.update(sql,new BeanPropertySqlParameterSource(student));

    }


}
