package com.ingesup.StudentCore.services;

import com.ingesup.StudentCore.entities.Student;
import com.ingesup.StudentCore.exceptions.CantDeleteStudent;
import com.ingesup.StudentCore.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;



    public Iterable<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student getOneById(int id){
        return studentRepository.findById(id).get();
    }

    public Student createOne(Student toCreate){
        return studentRepository.save(toCreate);
    }

    public int updateGradeId(int studentId, int gradeId){
        return studentRepository.updateGradeId(studentId, gradeId);
    }

    public int updateLastName(int studentId, String lastName){
        return studentRepository.updateLastName(studentId, lastName);
    }

    public int updateFirstName(int studentId, String firstName){
        return studentRepository.updateFirstName(studentId, firstName);
    }

    public int updateBirthDate(int studentId, Date birthDate){
        return studentRepository.updateBirthDate(studentId, birthDate);
    }

    public Boolean deleteOneById(int studentId) throws CantDeleteStudent {
        boolean rep = false;
        try {
            studentRepository.deleteById(studentId);
            rep = true;
        }catch (Exception e){
            throw new CantDeleteStudent(studentId);
        }
        return rep;
    }
}
