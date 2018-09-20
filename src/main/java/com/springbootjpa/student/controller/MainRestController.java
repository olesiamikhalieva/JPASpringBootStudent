package com.springbootjpa.student.controller;

import com.springbootjpa.student.dto.StudentDTO;
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
    public String addStudent(@RequestBody StudentDTO studentDTO) {
        log.info("student {}________________________________", studentDTO.getTeachers().get(0));
        studentService.addStudent(studentDTO);
        return "student saved controller";
    }


    @GetMapping("/getAll")
    public List<StudentDTO> getStudent() {
        log.info("get all students");
        return studentService.getAllStudentAsStudentDTO();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllStudent() {
        log.info("delete all students");
        studentService.deleteAllStudent();
    }

    @GetMapping("/count")
    public Long countStudent() {
        log.info("count students");
        return studentService.countStudent();
    }

    @GetMapping("/find/age")
    public List<StudentDTO> findStudentByAge(@Param(value = "age") int age) {
        log.info("find students by age");
        return studentService.findStudentsByAge(age);
    }

    @GetMapping("/find/ageAfter")
    public List<StudentDTO> findStudentByAgeAfter(@Param(value = "ageAfter") int ageAfter) {
        log.info("find students by surname and age after");
        return studentService.findStudentByAgeAfter(ageAfter);
    }


    @GetMapping("/find/student/name+surname")
    public StudentDTO findStudentByNameAndSurname(@Param(value = "name") String name, @Param(value = "surname") String surname) {
        log.info("find students by name and surname" + name);
        return studentService.findStudentByNameAndSurname(name, surname);
    }

    @GetMapping("/find/student/name+surname+age")
    public StudentDTO findStudentByNameAndSurnameAndAge(@Param(value = "name") String name, @Param(value = "surname") String surname, @Param(value = "age") int age) {
        log.info("find students by name, surname and age");
        return studentService.findStudentByNameAndSurnameAndAge(name, surname, age);
    }


    @GetMapping("/find/student/adress/country+city")
    public StudentDTO findStudentByAdress_CountryAndAdress_City
            (@Param(value = "country") String country, @Param(value = "city") String city) {
        log.info("find students by country and city");
        return studentService.findStudentEntityByAdressEntity_CountryAndAdressEntity_City(country, city);
    }

}

