package com.ingesup.StudentCore.exceptions;

public class CantUpdateStudent extends CustomException {
    public CantUpdateStudent(int studentId, String reason) {
        super("Cant update student, id : " + studentId + " : " + reason);
    }
}
