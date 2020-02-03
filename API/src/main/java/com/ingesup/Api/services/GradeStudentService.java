package com.ingesup.Api.services;

import com.ingesup.Api.clients.IGradeStudent;
import com.ingesup.Api.entities.Grade;
import com.ingesup.Api.entities.GradeStudentDTO;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Data
public class GradeStudentService {

    private IGradeStudent iGradeStudent = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudent.class, "http://localhost:8083/grades");

    /*
    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8082/students");*/

    public GradeStudentDTO getGradeStudent(Integer Id){
        log.info("Call to the student client - getOneById : " + Id);

        //Student student = iStudentClient.getOneById(Id);

        log.info("Call to the grade client - getAll");
        List<Grade> gradeStudents = iGradeStudent.getAll();

        //return new GradeStudentDTO(student, gradeStudents);
        return new GradeStudentDTO(null, gradeStudents);

    }
}
