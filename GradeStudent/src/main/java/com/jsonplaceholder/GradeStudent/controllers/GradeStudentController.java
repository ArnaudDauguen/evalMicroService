package com.jsonplaceholder.GradeStudent.controllers;

import com.jsonplaceholder.GradeStudent.entities.GradeStudentDTO;
import com.jsonplaceholder.GradeStudent.entities.StudentsGradeDTO;
import com.jsonplaceholder.GradeStudent.services.GradeStudentService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;

    @RequestMapping("/gradeStudent/{gradeId}")
    ResponseEntity<GradeStudentDTO> getGradeStudent(@PathVariable Integer gradeId){
        return new ResponseEntity<>(gradeStudentService.getStudentsGrade(gradeId), HttpStatus.OK);
    }

    @RequestMapping("/gradeStudent/")
    ResponseEntity<List<GradeStudentDTO>> getStudentsByGradeId() {
        return new ResponseEntity<>(gradeStudentService.getAllStudentsByGrades(), HttpStatus.OK);
    }
}
