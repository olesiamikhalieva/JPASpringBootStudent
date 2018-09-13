package com.springbootjpa.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTO {

    @JsonProperty("adress")
    private AdressDTO adress;
    @JsonProperty("age")
    private int age;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("name")
    private String name;

    public StudentDTO() {
    }

    public StudentDTO(AdressDTO adress, int age, String surname, String name) {
        this.adress = adress;
        this.age = age;
        this.surname = surname;
        this.name = name;
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
