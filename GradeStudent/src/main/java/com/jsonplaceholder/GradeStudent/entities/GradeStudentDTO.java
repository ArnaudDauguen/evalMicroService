package com.jsonplaceholder.GradeStudent.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeStudentDTO { //DTO: Data Transfer Object
    private Student student;
    private List<Grade> grades;
    private List<Student> students;
    private List<List<Student>> studentsByGrade;
    private Grade grade;

    public GradeStudentDTO(Student student, List<Grade> gradeStudents) {
        this.student = student;
        this.grades = gradeStudents;
    }

    public GradeStudentDTO(List<Student> students, Grade grade) {
        this.students = students;
        this.grade = grade;
    }

    public GradeStudentDTO(List<Grade> grades, List<List<Student>> studentsByGrade) {
        this.grades = grades;
        this.studentsByGrade = studentsByGrade;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Grade> getGrade() {
        return grades;
    }

    public void setGrade(List<Grade> grades) {
        this.grades = grades;
    }
}
