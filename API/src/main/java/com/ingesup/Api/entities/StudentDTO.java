package com.ingesup.Api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDTO {
    private List<Student> students;

}
