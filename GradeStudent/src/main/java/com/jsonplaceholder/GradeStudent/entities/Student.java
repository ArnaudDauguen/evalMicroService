package com.jsonplaceholder.GradeStudent.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer gradeId;
    private Date birthDate;
}
