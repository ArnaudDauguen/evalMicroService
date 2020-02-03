package com.ingesup.Api.controllers;

import com.ingesup.Api.clients.IStudent;
import com.ingesup.Api.entities.StudentDTO;
import com.ingesup.Api.services.GradeStudentService;
import com.ingesup.Api.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;

    private IStudent iStudent = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudent.class, "http://localhost:8082/students");



    /*
    @GetMapping("/gradeStudent/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }*/




    @GetMapping("/students")
    ResponseEntity<StudentDTO> getStudents(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }
/*
    @GetMapping("/students/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }*/

}
