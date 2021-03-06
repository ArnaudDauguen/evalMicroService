package com.jsonplaceholder.GradeStudent.clients;

import com.jsonplaceholder.GradeStudent.entities.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FeignClient(name="StudentClient")
public interface IStudentClient {

    @RequestLine("GET /")
    List<Student> getAll();

    @RequestLine("GET /{id}")
    Student getOneById(@Param("id") Integer id);

    @RequestLine("GET /grade/{gradeId}")
    List<Student> getAllByGradeId(@Param("gradeId") Integer gradeId);
}
