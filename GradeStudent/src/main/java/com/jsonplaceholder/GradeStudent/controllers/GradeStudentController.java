package com.jsonplaceholder.GradeStudent.controllers;

import com.jsonplaceholder.GradeStudent.entities.GradeStudentDTO;
import com.jsonplaceholder.GradeStudent.services.GradeStudentService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;

    @RequestMapping("/gradeStudent/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }

}
