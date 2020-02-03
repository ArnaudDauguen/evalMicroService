package com.ingesup.StudentCore.controllers;

import com.ingesup.StudentCore.entities.Student;
import com.ingesup.StudentCore.exceptions.CantCreateStudent;
import com.ingesup.StudentCore.exceptions.CantDeleteStudent;
import com.ingesup.StudentCore.exceptions.CantUpdateStudent;
import com.ingesup.StudentCore.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path="/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    //GET all
    @GetMapping()
    public @ResponseBody
    Iterable<Student> getAll(){
        return studentService.getAll();
    }

    //GET one
    @GetMapping("/{id}")
    public @ResponseBody Student getOneById(@PathVariable int id){
        return studentService.getOneById(id);
    }

    //CREATE
    @PostMapping()
    public @ResponseBody Student addNewStudent(@RequestParam int gradeId,
                                               @RequestParam String firstName,
                                               @RequestParam String lastName,
                                               @RequestParam String birthDate
                                               ) throws ParseException {
        Date birth;
        try {
            birth = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        }catch(Exception e){
            throw new CantCreateStudent("invalid date, format must be dd/MM/yyyy");
        }

        Student n = new Student();
        n.setGradeId(gradeId);
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setBirthdate(birth);
        return studentService.createOne(n);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody Student updateStudent(@PathVariable int id,
                                               @RequestParam(required = false) String gradeId,
                                               @RequestParam(required = false) String lastName,
                                               @RequestParam(required = false) String firstName,
                                               @RequestParam(required = false) String birthDate){

        //gradeID
        try{
            if(gradeId != null) studentService.updateGradeId(id, Integer.parseInt(gradeId));
        }catch(Exception e){
            throw new CantUpdateStudent(id, "Invalid gradeId : " + gradeId);
        }
        if(lastName != null) studentService.updateLastName(id, lastName);
        if(firstName != null) studentService.updateFirstName(id, firstName);

        //Date
        try {
            if(birthDate != null) studentService.updateBirthDate(id, new SimpleDateFormat("dd/MM/yyyy").parse(birthDate));
        }catch(Exception e){
            throw new CantUpdateStudent(id, "invalid date, format must be dd/MM/yyyy");
        }
        return studentService.getOneById(id);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public @ResponseBody Boolean deleteOneById(@PathVariable int id) throws CantDeleteStudent {
        return studentService.deleteOneById(id);
    }

}
