package com.ingesup.GradeCore.exceptions;

public class CantDeleteGrade extends Exception {
    public CantDeleteGrade(int gradeId) {
        super("Can't delete grade, id : " + gradeId);
    }
}
