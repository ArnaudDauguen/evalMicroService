package com.ingesup.Api.services;

import com.ingesup.Api.clients.IStudentClient;
import com.ingesup.Api.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;


@Slf4j
public class StudentService {

    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8082/students");


    public List<Student> getAll(){
        return iStudentClient.getAll();
    }
    public Student getOneById(int id){
        return iStudentClient.getOneById(id);
    }
/*
    public Student createOne(Student toCreate){
        return studentRepository.save(toCreate);
    }
*/
/*
    public int updateGradeId(int studentId, int gradeId){
        return iStudentClient.updateGradeId(studentId, gradeId);
    }

    public int updateLastName(int studentId, String lastName){
        return studentRepository.updateLastName(studentId, lastName);
    }

    public int updateFirstName(int studentId, String firstName){
        return studentRepository.updateFirstName(studentId, firstName);
    }

    public int updateBirthDate(int studentId, Date birthDate){
        return studentRepository.updateBirthDate(studentId, birthDate);
    }

    public Boolean deleteOneById(int studentId) throws CantDeleteStudent {
        boolean rep = false;
        try {
            studentRepository.deleteById(studentId);
            rep = true;
        }catch (Exception e){
            throw new CantDeleteStudent(studentId);
        }
        return rep;
    }

    public Iterable<Student> getAllByGradeId(int gradeId) {
        return studentRepository.getAllByGradeId(gradeId);
    }
*/

}
