package com.ingesup.Api.services;

import com.ingesup.Api.clients.IStudentClient;
import com.ingesup.Api.entities.Student;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

import java.util.List;

public class StudentService {

    private IStudentClient iStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IStudentClient.class, "http://localhost:8082/students");


    public List<Student> getAll(){
        List<Student> lst = iStudentClient.getAll();
        System.out.println(lst.toString());
        return lst;
    }


}
