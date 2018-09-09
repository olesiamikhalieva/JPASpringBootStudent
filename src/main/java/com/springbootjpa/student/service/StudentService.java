package com.springbootjpa.student.service;

import com.springbootjpa.student.dao.entity.Student;
import com.springbootjpa.student.dao.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    public List<Student> allStudent() {
        return studentRepository.findAll();
    }


    public Student findStudentBySurnameAndAge(String surname, int age) {
        return studentRepository.findStudentBySurnameAndAge(surname, age);
    }

    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public Long countStudent() {
        return studentRepository.count();
    }

    public List<Student> findStudentsByAge(int age) {
        return studentRepository.findStudentsByAge(age);
    }

    public List<Student> findStudentByAgeAfter(int ageAfter) {
        return studentRepository.findStudentsByAgeAfter(ageAfter);
    }

    public Student findStudentByNameAndSurname(String name, String surname) {
        return studentRepository.findStudentByNameAndSurname(name, surname);
    }

    public Student findStudentByNameAndSurnameAndAge(String name, String surname, int age) {
        return studentRepository.findStudentByNameAndSurnameAndAge(name, surname, age);
    }

    public Student findStudentByAdress_CountryAndAdress_CityAndAdress_StreetAndAdress_NumberHouse(String country, String city, String street, int numberHouse) {
        return studentRepository.findStudentByAdress_CountryAndAdress_CityAndAdress_StreetAndAdress_NumberHouse(country, city, street, numberHouse);
    }

    public Student findStudentByAdress_CountryAndAdress_City(String country, String city) {
        return studentRepository.findStudentByAdress_CountryAndAdress_City(country, city);
    }

    public Student findStudentByAdress_StreetAndAdress_NumberHouse(String street, int numberHouse) {
        return studentRepository.findStudentByAdress_StreetAndAdress_NumberHouse(street, numberHouse);
    }


}

