package com.ingesup.StudentCore.exceptions;

public class StudentNotFound extends CustomException {
    public StudentNotFound(int studentId) {
        super("Student not found, id : " + studentId);
    }
}
