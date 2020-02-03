package com.ingesup.StudentCore.repositories;

import com.ingesup.StudentCore.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Student SET gradeId = :gradeId WHERE id = :studentId")
    int updateGradeId(@Param("studentId") int studentId, @Param("gradeId") int gradeId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Student SET firstName = :firstName WHERE id = :studentId")
    int updateFirstName(@Param("studentId") int studentId, @Param("firstName") String firstName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Student SET lastName = :lastName WHERE id = :studentId")
    int updateLastName(@Param("studentId") int studentId, @Param("lastName") String lastName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Student SET birthDate = :birthDate WHERE id = :studentId")
    int updateBirthDate(@Param("studentId") int studentId, @Param("birthDate") Date birthDate);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM student where  grade_id = :gradeId",
            nativeQuery = true)
    List<Student> getAllByGradeId(@Param("gradeId") int gradeId);

}
