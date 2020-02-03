package com.ingesup.GradeCore.repositories;

import com.ingesup.GradeCore.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GradeRepository extends CrudRepository<Grade, Integer> {

    @Transactional // pour eviter corruption et executer asap
    @Modifying(clearAutomatically = true) // pour eviter corruption
    @Query("UPDATE Grade g SET g.headTeacher = :headTeacher WHERE g.id = :gradeId")
    int updateHeadTeacher ( @Param("gradeId") int gradeId, @Param("headTeacher") String headTeacher);


    @Transactional // pour eviter corruption et executer asap
    @Modifying(clearAutomatically = true) // pour eviter corruption
    @Query(value = "SELECT * FROM Grade where id = :id",
            nativeQuery = true)
    List<Grade> getAllByUserId(@Param("id") int userId);



}
