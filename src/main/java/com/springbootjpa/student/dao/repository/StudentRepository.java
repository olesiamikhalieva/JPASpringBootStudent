package com.springbootjpa.student.dao.repository;

import com.springbootjpa.student.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findStudentsByAge(int age);

    List<StudentEntity> findStudentsByAgeAfter(int age);

    StudentEntity findStudentBySurnameAndAge(String surname, int age);

    StudentEntity findStudentByNameAndSurname(String name, String surname);

    StudentEntity findStudentByNameAndSurnameAndAge(String name, String surname, int age);

    StudentEntity findStudentEntityByAdressEntity_CountryAndAdressEntity_City(String country, String city);








}
