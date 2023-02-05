package com.manage.student.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manage.student.bean.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
	
	List<Student> findByName(String name);
	List<Student> findByNameAndHomeTown(String name,String homeTown);
	List<Student> findByNameOrStudentGuide(String name,String sguide);
	List<Student> findByNameContaining(String nameToken);
	

	@Query("FROM Student where name =:name and studentGuide=:guide")
	List<Student> getStudentDetailByNameAndGuide(@Param("name")String sname, String guide);
	
	@Transactional
	@Modifying
	@Query("Delete from Student where name = :sname")
	Integer deleteStudentByName(@Param("sname") String name);
	
	@Query(value="select * from tab_student_detail", nativeQuery = true)
	List<Student> getStudents();

}
