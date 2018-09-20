package com.springbootjpa.student.service;

import com.springbootjpa.student.dao.entity.AdressEntity;
import com.springbootjpa.student.dao.entity.StudentEntity;
import com.springbootjpa.student.dao.entity.TaskEntity;
import com.springbootjpa.student.dao.entity.TeacherEntity;
import com.springbootjpa.student.dao.repository.StudentRepository;
import com.springbootjpa.student.dao.repository.TeacherRepository;
import com.springbootjpa.student.dto.AdressDTO;
import com.springbootjpa.student.dto.StudentDTO;
import com.springbootjpa.student.dto.TaskDTO;
import com.springbootjpa.student.dto.TeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    public List<StudentDTO> getAllStudentAsStudentDTO() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentEntity st : studentRepository.findAll()) {
            studentDTOList.add(constructStudentDTO(st));
        }
        return studentDTOList;
    }

    private StudentDTO constructStudentDTO(StudentEntity studentEntity) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAge(studentEntity.getAge());
        studentDTO.setName(studentEntity.getName());
        studentDTO.setSurname(studentEntity.getSurname());

        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setCountry(studentEntity.getAdressEntity().getCountry());
        adressDTO.setCity(studentEntity.getAdressEntity().getCity());
        adressDTO.setStreet(studentEntity.getAdressEntity().getStreet());
        adressDTO.setNumberHouse(studentEntity.getAdressEntity().getNumberHouse());

        studentDTO.setAdress(adressDTO);

        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (TaskEntity task : studentEntity.getTasks()) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTasks(task.getTask());
            taskDTOList.add(taskDTO);
        }
        studentDTO.setTasks(taskDTOList);
        return studentDTO;
    }


    public String addStudent(StudentDTO studentDTO) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDTO.getName());
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setAge(studentDTO.getAge());

        AdressEntity adressEntity = new AdressEntity();
        adressEntity.setCountry(studentDTO.getAdress().getCountry());
        adressEntity.setCity(studentDTO.getAdress().getCity());
        adressEntity.setStreet(studentDTO.getAdress().getStreet());
        adressEntity.setNumberHouse(studentDTO.getAdress().getNumberHouse());

        studentEntity.setAdressEntity(adressEntity);

        List<TaskEntity>taskEntityList = new ArrayList<>();
        for (TaskDTO taskDTO : studentDTO.getTasks()) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTask(taskDTO.getTask());
            taskEntityList.add(taskEntity);
        }
        studentEntity.setTasks(taskEntityList);

        List<TeacherEntity>teacherEntityList = new ArrayList<>();
        for (TeacherDTO teacherDTO : studentDTO.getTeachers()) {
            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setSurname(teacherDTO.getSurname());
            teacherEntityList.add(teacherEntity);
        }
        studentEntity.setTeachers(teacherEntityList);
        try {
            studentRepository.saveAndFlush(studentEntity);
            for (TeacherEntity teacher : studentEntity.getTeachers()) {
                teacherRepository.saveAndFlush(teacher);
            }
            log.info("student saved");
            return "-------saved";
        }
        catch (Exception e){
            log.error(" student don't save in DB");
            e.printStackTrace();
            return " error, student don't save, see you log";
        }


    }


    public StudentDTO findStudentBySurnameAndAge(String surname, int age) {
        StudentEntity studentEntity = studentRepository.findStudentBySurnameAndAge(surname, age);
        return constructStudentDTO(studentEntity);
    }

    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    public Long countStudent() {
        return studentRepository.count();
    }

    public List<StudentDTO> findStudentsByAge(int age) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentEntity st : studentRepository.findStudentsByAge(age)) {
            studentDTOList.add(constructStudentDTO(st));
        }
        return studentDTOList;
    }

    public List<StudentDTO> findStudentByAgeAfter(int ageAfter) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentEntity st : studentRepository.findStudentsByAgeAfter(ageAfter)) {
            studentDTOList.add(constructStudentDTO(st));
        }
        return studentDTOList;
    }

    public StudentDTO findStudentByNameAndSurname(String name, String surname) {
        StudentEntity studentEntity = studentRepository.findStudentByNameAndSurname(name, surname);
        return constructStudentDTO(studentEntity);
    }

    public StudentDTO findStudentByNameAndSurnameAndAge(String name, String surname, int age) {
        StudentEntity studentEntity = studentRepository.findStudentByNameAndSurnameAndAge(name, surname, age);
        return constructStudentDTO(studentEntity);
    }


    public StudentDTO findStudentEntityByAdressEntity_CountryAndAdressEntity_City(String country, String city) {
        StudentEntity studentEntity = studentRepository.findStudentEntityByAdressEntity_CountryAndAdressEntity_City(country,city);
        return constructStudentDTO(studentEntity);
    }



}

