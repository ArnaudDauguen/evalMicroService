package com.ingesup.Api.entities;
import lombok.Data;
import java.util.Date;

@Data
public class Student {
    private Integer id;
    private Integer gradeId;
    private String firstName;
    private String lastName;
    private Date birthdate;

}