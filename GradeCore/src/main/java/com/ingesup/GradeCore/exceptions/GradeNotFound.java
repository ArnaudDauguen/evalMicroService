package com.ingesup.GradeCore.exceptions;

public class GradeNotFound extends CustomException {
    public GradeNotFound(int gradeId) {
        super("Grade not found, id : " + gradeId);
    }
}
