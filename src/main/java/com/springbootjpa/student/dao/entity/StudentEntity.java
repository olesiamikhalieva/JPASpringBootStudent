package com.springbootjpa.student.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;


@Entity
@Table

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AdressEntity adressEntity;

    public StudentEntity() {
    }

    public StudentEntity(String name, String surname, int age, AdressEntity adressEntity) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.adressEntity = adressEntity;
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
}
