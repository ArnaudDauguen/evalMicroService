package com.jsonplaceholder.GradeStudent.services;

import com.jsonplaceholder.GradeStudent.clients.IGradeClient;
import com.jsonplaceholder.GradeStudent.clients.IStudentClient;
import com.jsonplaceholder.GradeStudent.entities.Grade;
import com.jsonplaceholder.GradeStudent.entities.Student;
import com.jsonplaceholder.GradeStudent.entities.GradeStudentDTO;
import com.jsonplaceholder.GradeStudent.entities.StudentsGradeDTO;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Data
public class GradeStudentService {

    private IGradeClient iGradeClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeClient.class, "http://localhost:8081/grades");

    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8082/students");


    public GradeStudentDTO getStudentsGrade(Integer gradeId) {
        log.info("Call to the student client - getAllByGradeId : " + gradeId);
        List<Student> students = iStudentClient.getAllByGradeId(gradeId);

        log.info("Call to the grade client - getOneById : " + gradeId);
        Grade grade = iGradeClient.getOneById(gradeId);

        return new GradeStudentDTO(students, grade);
    }

    public List<GradeStudentDTO> getAllStudentsByGrades() {
        List<Grade> grades = iGradeClient.getAll();
        int gradesLen = grades.size();

        List<GradeStudentDTO> rep = new ArrayList<GradeStudentDTO>();

        for (int i = 0; i < gradesLen; i++) {
            rep.add(new GradeStudentDTO(iStudentClient.getAllByGradeId(grades.get(i).getId()), grades.get(i)));
        }
        return rep;
    }
}
