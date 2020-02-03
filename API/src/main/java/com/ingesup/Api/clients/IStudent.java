package com.ingesup.Api.clients;

import com.ingesup.Api.entities.Grade;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name= "Students")
public interface IStudent {

    @RequestLine("GET /students")
    List<Grade> getAll();
  /*  @RequestLine("GET /students/{id}")
    <id>
    List<Grade> getOneById(id);
    @RequestLine("GET /students")
    List<Grade> getAll();
    @RequestLine("GET /students")
    List<Grade> getAll();
    @RequestLine("GET /students")
    List<Grade> getAll();
    @RequestLine("GET /students")
    List<Grade> getAll();
    @RequestLine("GET /students")
    List<Grade> getAll();*/
}
