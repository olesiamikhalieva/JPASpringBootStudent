package com.springbootjpa.student.controller;


import com.springbootjpa.student.dao.entity.Student;
import com.springbootjpa.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class MainRestController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String test() {
        log.info("test work ---------------------------------");
        return "Test";
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        log.info("student {}", student);
        studentService.addStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getStudent() {
        log.info("get all students");
        return studentService.allStudent();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllStudent() {
        log.info("delete all students");
        studentService.deleteAllStudent();
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@PathVariable Student student) {
        log.info("delete student");
        studentService.deleteStudent(student);
    }

    @GetMapping("/count")
    public Long countStudent() {
        log.info("count students");
        return studentService.countStudent();
    }

    @GetMapping("/find/age")
    public List<Student> findStudentByAge(@Param(value = "age") int age) {
        log.info("find students by age");
        return studentService.findStudentsByAge(age);
    }

    @GetMapping("/find/ageAfter")
    public List<Student> findStudentByAgeAfter(@Param(value = "ageAfter") int ageAfter) {
        log.info("find students by surname and age after");
        return studentService.findStudentByAgeAfter(ageAfter);
    }


    @GetMapping("/find/")
    public Student findStudentByNameAndSurname(@Param(value = "name") String name, @Param(value = "surname") String surname) {
        log.info("find students by name and surname" + name);
        return studentService.findStudentByNameAndSurname(name, surname);
    }

//    @GetMapping("/find")
//    public Student findStudentByNameAndSurnameAndAge(@Param(value = "name") String name, @Param(value = "surname") String surname, @Param(value = "age") int age) {
//        log.info("find students by name, surname and age");
//        return studentService.findStudentByNameAndSurnameAndAge(name, surname, age);
//    }
//
//    @GetMapping("/find")
//    public Student findStudentByAdress_CountryAndAdress_CityAndAdress_StreetAndAdress_NumberHouse
//            (@Param(value = "country") String country, @Param(value = "city") String city,
//             @Param(value = "street") String street, @Param(value = "numberHouse") int numberHouse) {
//        log.info("find students by country, city, street, numberHouse");
//        return studentService.findStudentByAdress_CountryAndAdress_CityAndAdress_StreetAndAdress_NumberHouse(country, city, street, numberHouse);
//    }
//
//    @GetMapping("/find")
//    public Student findStudentByAdress_CountryAndAdress_City
//            (@Param(value = "country") String country, @Param(value = "city") String city) {
//        log.info("find students by country and city");
//        return studentService.findStudentByAdress_CountryAndAdress_City(country, city);
//    }
//
//    @GetMapping("/find")
//    public Student findStudentByAdress_StreetAndAdress_NumberHouse
//            (@Param(value = "street") String street, @Param(value = "numberHouse") int numberHouse) {
//        log.info("find students by street and numberHouse");
//        return studentService.findStudentByAdress_StreetAndAdress_NumberHouse(street, numberHouse);
//    }
}

