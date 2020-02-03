package com.ingesup.Api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeStudentDTO { //DTO: Data Transfer Object
    private List<Student> student;
    private Grade grade;
}
