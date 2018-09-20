package com.springbootjpa.student.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "teachers")
@Data
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "teacher_id")
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
//    @JoinTable(name = "teachers",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
    private List<StudentEntity>students;

    public TeacherEntity() {
    }

    public TeacherEntity(String name, String surname, List<StudentEntity> students) {
        this.name = name;
        this.surname = surname;
        this.students = students;
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

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
