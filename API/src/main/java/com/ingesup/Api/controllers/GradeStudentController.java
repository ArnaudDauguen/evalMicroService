package com.ingesup.Api.controllers;

import com.ingesup.Api.entities.GradeStudentDTO;
import com.ingesup.Api.entities.Student;
import com.ingesup.Api.services.GradeStudentService;
import com.ingesup.Api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeStudentController {

    @Autowired
    GradeStudentService gradeStudentService;
    StudentService studentService = new StudentService();
    GradeStudentService gardeStudentService = new GradeStudentService();



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

    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    ResponseEntity<Student> getOneStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/gradeStudent")
    ResponseEntity<List<GradeStudentDTO>> getGradeStudents(){
        return new ResponseEntity<>(gradeStudentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/gradeStudent/{id}")
    ResponseEntity<GradeStudentDTO> getOneGradeStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(gradeStudentService.getOneGradeStudentById(id), HttpStatus.OK);
    }

}
