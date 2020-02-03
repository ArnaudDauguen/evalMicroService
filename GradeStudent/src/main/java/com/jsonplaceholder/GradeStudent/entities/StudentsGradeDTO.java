package com.jsonplaceholder.GradeStudent.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentsGradeDTO { //DTO: Data Transfer Object
    private Grade grade;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grades) {
        this.grade = grades;
    }
}
