package com.ingesup.GradeCore.services;

import com.ingesup.GradeCore.entities.Grade;
import com.ingesup.GradeCore.exceptions.CantDeleteGrade;
import com.ingesup.GradeCore.entities.Grade;
import com.ingesup.GradeCore.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    /* public Iterable<Grade> getAll();
     * Get all grades.
     *
     * returns a List containing every grades.
     */
    public Iterable<Grade> getAll(){
        return gradeRepository.findAll();
    }

    /* public Grade getOneById(int id);
     * Get a specific grade by it's id.
     *
     * id : grade id.
     *
     * returns a grade.
     */
    public Grade getOneById(int id){
        return gradeRepository.findById(id).get();
    }

    /* public Grade createOne(Grade toCreate);
     * Allow to create a new grade.
     */
    public Grade createOne(Grade toCreate){
        return gradeRepository.save(toCreate);
    }

    /* public int updateHeadTeacher(int gradeId, String headTeacher);
     * Allow to update headTeacher for a specific grade.
     *
     * gradeId : id
     * headTeacher : new name for the headTeacher
     */
    public int updateHeadTeacher(int gradeId, String headTeacher) {
        return gradeRepository.updateHeadTeacher(gradeId, headTeacher);
    }

    /* public Boolean deleteOneById(int gradeId);
     * Allow to delete a specific grade.
     *
     * gradeId : id.
     *
     * returns true if a grade is deleted successfully, throw a custom error otherwise.
     */
    public Boolean deleteOneById(int gradeId) throws CantDeleteGrade {
        boolean rep = false;
        try {
            gradeRepository.deleteById(gradeId);
            rep = true;
        }catch (Exception e){
            throw new CantDeleteGrade(gradeId);
        }
        return rep;
    }
}
