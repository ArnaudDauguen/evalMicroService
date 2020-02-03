package com.ingesup.StudentCore.exceptions;

public class CantDeleteStudent extends CustomException {
    public CantDeleteStudent(int studentId) {
        super("Can't delete student, id : " + studentId);
    }
}
