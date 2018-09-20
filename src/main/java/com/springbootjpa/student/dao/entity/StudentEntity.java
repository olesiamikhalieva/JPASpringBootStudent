package com.springbootjpa.student.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity()
@Table(name = "students")

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "student_id")
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "adress_id")
    private AdressEntity adressEntity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TaskEntity> tasks;

    @ManyToMany(mappedBy = "students")
    private List<TeacherEntity> teachers;

    public StudentEntity() {
    }

    public StudentEntity(String name, String surname, int age, AdressEntity adressEntity) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adressEntity = adressEntity;
    }

    public StudentEntity(String name, String surname, int age, AdressEntity adressEntity, List<TaskEntity> tasks, List<TeacherEntity> teachers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adressEntity = adressEntity;
        this.tasks = tasks;
        this.teachers = teachers;
    }

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AdressEntity getAdressEntity() {
        return adressEntity;
    }

    public void setAdressEntity(AdressEntity adressEntity) {
        this.adressEntity = adressEntity;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
