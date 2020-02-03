package com.ingesup.StudentCore.exceptions;

public class CantCreateStudent extends CustomException {
    public CantCreateStudent(String reason) {
        super("Cant create student : " + reason);
    }
}
