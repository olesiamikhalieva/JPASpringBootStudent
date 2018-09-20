package com.springbootjpa.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootjpa.student.dao.entity.StudentEntity;

import java.util.List;

public class TeacherDTO {
    @JsonProperty("surname")
    private String surname;

    public TeacherDTO(String surname) {
        this.surname = surname;
    }

    public TeacherDTO() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
