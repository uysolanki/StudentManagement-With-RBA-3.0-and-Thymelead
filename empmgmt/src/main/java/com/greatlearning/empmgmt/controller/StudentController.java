package com.greatlearning.empmgmt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.empmgmt.entity.Student;
import com.greatlearning.empmgmt.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studservice;
	
	@RequestMapping("/readstudentlist")
	public String listStudents(Model model)
	{
		List<Student> liststudents=studservice.getAllStudents();
		model.addAttribute("studentsfe",liststudents);
		return "students";
	}

	@GetMapping("/students/addform")
	public String createStudentForm(Model model)
	{
		Student s1=new Student();
		model.addAttribute("student",s1);
		return "create_student";
		
	}
	
	@PostMapping("/addstudent")
	public String addstudent(@ModelAttribute Student student)
	{
		studservice.addStudent(student);
		return "redirect:/readstudentlist";
	}

	@GetMapping("/students/editform/{id}")
	public String editStudentForm(@PathVariable("id") int studid, Model model)
	{
		Student studdb=studservice.getStudent(studid);
		model.addAttribute("student",studdb);
		return "edit_student";
	}

	@PostMapping("/updatestudent/{id}")
	public String updateStudent(@PathVariable("id") int studid, @ModelAttribute("student") Student student)
	{
		studservice.updateStudent(studid,student);
		return "redirect:/readstudentlist";
	}

	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") int studid)
	{
		studservice.deleteStudent(studid);
		return "redirect:/readstudentlist";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}


}
