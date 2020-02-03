package com.ingesup.GradeCore.exceptions;

public class CantUpdateGrade extends Exception {
    public CantUpdateGrade(int gradeId) {
        super("Can't update grade, id : " + gradeId);
    }
}
