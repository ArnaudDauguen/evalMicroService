package com.ingesup.Api.controllers;

import com.ingesup.Api.clients.IStudentClient;
import com.ingesup.Api.entities.GradeStudentDTO;
import com.ingesup.Api.entities.Student;
import com.ingesup.Api.entities.StudentDTO;
import com.ingesup.Api.services.GradeStudentService;
import com.ingesup.Api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;
    StudentService studentService = new StudentService();



/*
    @GetMapping("/gradeStudent/{Id}")
    ResponseEntity<GradeStudentDTO> getUserTodos(@PathVariable Integer Id){
        return new ResponseEntity<>(gradeStudentService.getGradeStudent(Id), HttpStatus.OK);
    }*/



/*
//méthode de cheat absolue
    @RequestMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getStudents(){
        String response = "";
        try {
            String requestURL = "http://localhost:8082/students";
            URL wikiRequest = new URL(requestURL);
            URLConnection connection = wikiRequest.openConnection();
            connection.setDoOutput(true);

            Scanner scanner = new Scanner(wikiRequest.openStream());
            response = scanner.useDelimiter("\\Z").next();

            scanner.close();
        }catch(Exception e){}

        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

    @GetMapping(value = "/students")
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
