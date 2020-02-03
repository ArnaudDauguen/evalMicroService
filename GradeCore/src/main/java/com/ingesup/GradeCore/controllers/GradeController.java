package com.ingesup.GradeCore.controllers;

import com.ingesup.GradeCore.entities.Grade;
import com.ingesup.GradeCore.exceptions.CantDeleteGrade;
import com.ingesup.GradeCore.exceptions.CantUpdateGrade;
import com.ingesup.GradeCore.services.GradeService;
import com.ingesup.GradeCore.entities.Grade;
import com.ingesup.GradeCore.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;


    //GET all
    @GetMapping()
    public @ResponseBody
    Iterable<Grade> getAll(){
        return gradeService.getAll();
    }

    //GET one
    @GetMapping("/{id}")
    public @ResponseBody Grade getOneById(@PathVariable int id){
        return gradeService.getOneById(id);
    }

    //CREATE
    @PostMapping()
    public @ResponseBody Grade addNewGrade(@RequestParam String title, @RequestParam String headTeacher, @RequestParam int year){
        Grade g = new Grade();
        g.setHeadTeacher(headTeacher);
        g.setTitle(title);
        g.setYear(year);
        return gradeService.createOne(g);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody Grade updateGrade(@PathVariable int id, @RequestParam String headTeacher) throws CantUpdateGrade {
        gradeService.updateHeadTeacher(id, headTeacher);
        return gradeService.getOneById(id);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public @ResponseBody Boolean deleteOneById(@PathVariable int id) throws CantDeleteGrade {
        return gradeService.deleteOneById(id);
    }

}
