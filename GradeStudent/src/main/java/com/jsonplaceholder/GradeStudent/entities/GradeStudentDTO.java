package com.jsonplaceholder.GradeStudent.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeStudentDTO { //DTO: Data Transfer Object
    private List<Student> students;
    private Grade grade;
}
