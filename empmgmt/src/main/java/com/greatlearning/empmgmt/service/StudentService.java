package com.greatlearning.empmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.empmgmt.entity.Student;
import com.greatlearning.empmgmt.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	StudentRepository studRepo;

	public List<Student> getAllStudents() {
		return studRepo.findAll();
	}

	public void addStudent(Student student) {
		studRepo.save(student);
		
	}

	public Student getStudent(int studid) {
		return studRepo.findById(studid).get();
	}

	public void updateStudent(int studid, Student student) {
		Student studdb=studRepo.findById(studid).get();
		studdb.setFirstName(student.getFirstName());
		studdb.setLastName(student.getLastName());
		studdb.setCourse(student.getCourse());
		studdb.setCountry(student.getCountry());
		studdb.setEmail(student.getEmail());
		studdb.setGender(student.getGender());
		studRepo.save(studdb);
	}

	public void deleteStudent(int studid) {
		studRepo.deleteById(studid);
		
	}
}
