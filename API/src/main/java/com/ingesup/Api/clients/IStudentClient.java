package com.ingesup.Api.clients;

import com.ingesup.Api.entities.Grade;
import com.ingesup.Api.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name="StudentClient")
public interface IStudentClient {

    @RequestLine("GET /")
    List<Student> getAll();

    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Integer id);

    @RequestMapping("PUT /{id}")
    Student updateGradeId(@Param("id")Integer id, @RequestParam("gradeId") Integer gradeId);

}
