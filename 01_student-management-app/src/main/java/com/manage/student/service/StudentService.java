package com.manage.student.service;

import java.util.List;

/*
 * #The same repo method 'save()'is used for saving and also updating the records in the table. 
 * If we want the save method to update a row then we need to pass the id in the request body passed as an argument to the save method.
 * while if we want to just create a new row then we need to send the request body without any id
 * 
 * If we pass a request body to the save method with an invalid id value then it is treated as if no id was passed and will create a new row with the values in the
 * request body.
 * 
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manage.student.bean.Student;
import com.manage.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public Student saveStudentDetail(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getAllStudentDetail(){
		return (List<Student>) studentRepo.findAll();
	}
	
	public Student getStudentDetail(Integer id){
		return studentRepo.findById(id).get();
	}
	
	public void deleteStudent(Integer id){
		studentRepo.deleteById(id);
	}	
	
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public List<Student> getStudentsByName(String name) {
		return studentRepo.findByName(name);
	}
	
	public List<Student> getStudentsByNameAndHometown(String name, String homeTown) {
		return studentRepo.findByNameAndHomeTown(name, homeTown);
	}
	
	public List<Student> getStudentsByNameOrStudentGuide(String name, String sguide) {
		return studentRepo.findByNameOrStudentGuide(name, sguide);
	}
	
	public List<Student> findByNameToken(String nameToken){
		return studentRepo.findByNameContaining(nameToken);
	}
	
	public List<Student> getStudentDetailByNameAndGuide(String name,String guide){
		return studentRepo.getStudentDetailByNameAndGuide(name, guide);
	}
	
	public Integer deleteStudentByName(String name){
		return studentRepo.deleteStudentByName(name);
	}
	
	public List<Student> getAllStudents(){
		return studentRepo.getStudents();
	}

}
