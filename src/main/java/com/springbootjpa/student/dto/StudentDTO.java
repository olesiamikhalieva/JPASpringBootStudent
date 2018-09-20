package com.springbootjpa.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentDTO {

    @JsonProperty("adress")
    private AdressDTO adress;
    @JsonProperty("age")
    private int age;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tasks")
    private List<TaskDTO>tasks;
    @JsonProperty("teachers")
    private List<TeacherDTO>teachers;

    public StudentDTO() {
    }

    public StudentDTO(AdressDTO adress, int age, String surname, String name) {
        this.adress = adress;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public StudentDTO(AdressDTO adress, int age, String surname, String name, List<TaskDTO> tasks, List<TeacherDTO> teachers) {
        this.adress = adress;
        this.age = age;
        this.surname = surname;
        this.name = name;
        this.tasks = tasks;
        this.teachers = teachers;
    }

    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public AdressDTO getAdress() {
        return adress;
    }

    public void setAdress(AdressDTO adress) {
        this.adress = adress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
