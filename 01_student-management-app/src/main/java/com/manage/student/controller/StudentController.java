package com.manage.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.manage.student.bean.Student;
import com.manage.student.service.StudentService;

@RestController
@RequestMapping("/student_management_app/")
public class StudentController {

	/*
	 * Mappings are case sensitive so "/Hello" is not same as "/hello"
	 */
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save_student_detail")
	public Student saveStudentDetail(@RequestBody Student student) {
		return studentService.saveStudentDetail(student);
	}	
	
	@GetMapping("/get_all_student_detail")
	public List<Student> getAllStudentsDetail() {
		return studentService.getAllStudentDetail();
	}
	
	@GetMapping("/get_student_detail")
	public Student getStudentsDetail(@RequestParam("id") Integer id) {
		return studentService.getStudentDetail(id);
	}
	
	@DeleteMapping("/delete_student/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping("/update_student_detail")
	public Student updateStudentDetail(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping("/get_student_detail_by_name")
	public List<Student> getStudentsDetail(@RequestParam("sname") String name) {
		return studentService.getStudentsByName(name);
	}
	
	@GetMapping("/get_student_detail_by_name_and_hometown")
	public List<Student> getStudentsByNameAndHomeTown(@RequestParam("sname") String name,String homeTown) {
		return studentService.getStudentsByNameAndHometown(name, homeTown);
	}
	
	@GetMapping("/get_student_detail_by_name_or_guide")
	public List<Student> getStudentsByNameOrGuide(@RequestParam("sname") String name,String sguide) {
		return studentService.getStudentsByNameOrStudentGuide(name, sguide);
	}
	
	@GetMapping("/get_student_detail_by_name_by_pattern")
	public List<Student> getStudentsByNamePattern(@RequestParam String namePattern) {
		return studentService.findByNameToken(namePattern);
	}
	
	@GetMapping("/get_student_detail_by_name_and_guide")
	public List<Student> getStudentsByNameAndGuide(@RequestParam String name, @RequestParam String guide) {
		return studentService.getStudentDetailByNameAndGuide(name, guide);
	}
	
	@DeleteMapping("/delete_student_detail_by_name")
	public String deleteStudentByName(@RequestParam String name) {
		return studentService.deleteStudentByName(name)+" records deleted.";
	}
	
	@GetMapping("/get_student_detail_native")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}
	
	 
	
	
}
