package com.ingesup.Api.controllers;

import com.ingesup.Api.clients.IStudentClient;
import com.ingesup.Api.entities.GradeStudentDTO;
import com.ingesup.Api.entities.Student;
import com.ingesup.Api.entities.StudentDTO;
import com.ingesup.Api.services.GradeStudentService;
import com.ingesup.Api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;
    StudentService studentService;



/*
    @GetMapping("/gradeStudent/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }*/



    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }
/*
    @GetMapping("/students/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }
*/
}
