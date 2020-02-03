package com.ingesup.Api.services;

import com.ingesup.Api.clients.IGradeStudentClient;
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

    private IGradeStudentClient iGradeStudentClient = Feign.builder()
            .client(new OkHttpClient())
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .logger(new Slf4jLogger(String.class))
            .logLevel(Logger.Level.FULL)
            .target(IGradeStudentClient.class, "http://localhost:8083/gradeStudent");

    public List<GradeStudentDTO> getAll(){
        return iGradeStudentClient.getAll();
    }

    public GradeStudentDTO getOneGradeStudentById(Integer id){
        return iGradeStudentClient.getOneById(id);
    }


}
