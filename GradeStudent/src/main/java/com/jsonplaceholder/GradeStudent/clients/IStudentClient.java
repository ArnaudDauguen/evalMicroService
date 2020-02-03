package com.jsonplaceholder.GradeStudent.clients;

import com.jsonplaceholder.GradeStudent.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name="StudentClient")
public interface IStudentClient {

    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Integer id);

}
