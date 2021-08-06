package com.example.jdbclearning2.controller;

import com.example.jdbclearning2.dao.NewStudentDao;

import com.example.jdbclearning2.domain.Student;
import com.example.jdbclearning2.domain.StudentStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    //private StudentDao studentDao;// injecting the dao class
    NewStudentDao studentDao;
//
//    public StudentController(StudentDao studentDao) {
//        this.studentDao = studentDao;
//    }


    public StudentController(NewStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/student") //localhost:8080/student is the api to call the created table api.
    public Student createStudent() {
        Student student1 = Student.builder().firstName("harini").lastName("Nishant")
                .createDate(new Date()).updateDate(new Date()).status(StudentStatus.ACTIVE).build();
        return studentDao.createStudent(student1);

    }

//
//    @GetMapping("/student/all") //localhost:8080/student is the api to call the created table api.
//    public List<Student> getALL() {
//        return studentDao.getAllStudent();
//
//    }

    @GetMapping("/student/all/{id}") //localhost:8080/student is the api to call the created table api.
    public Student getAll(@PathVariable int id) {
        return studentDao.getStudentById(id);
    }
//
//
// @GetMapping("/create-table")
// public  void createTable(){
//       studentDao.createTable();
// }
//
//     @GetMapping("/count")// it counted the students and gave output as 3.
//    public Map<String,Integer> getStudentCount(){
//        return Collections.singletonMap("studentCount",studentDao.getStudentCount());
//    }// inorder to create a quick map with one key so used singletonMap


}
