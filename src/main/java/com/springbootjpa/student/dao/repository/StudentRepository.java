package com.springbootjpa.student.dao.repository;

import com.springbootjpa.student.dao.entity.Adress;
import com.springbootjpa.student.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAge(int age);

    List<Student> findStudentsByAgeAfter(int age);

    Student findStudentBySurnameAndAge(String surname, int age);

    Student findStudentByNameAndSurname(String name, String surname);

    Student findStudentByNameAndSurnameAndAge(String name, String surname, int age);

    Student findStudentByAdress_CountryAndAdress_CityAndAdress_StreetAndAdress_NumberHouse(String country, String city, String street, int numberHouse);

    Student findStudentByAdress_CountryAndAdress_City(String country, String city);

    Student findStudentByAdress_StreetAndAdress_NumberHouse(String street, int numberHouse);








}
