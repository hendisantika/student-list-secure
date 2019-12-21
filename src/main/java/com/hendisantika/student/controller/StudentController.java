package com.hendisantika.student.controller;

import com.hendisantika.student.model.Student;
import com.hendisantika.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
	@Autowired
    private StudentRepository repository; 

	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	
	
	@RequestMapping("/students")
	public String index(Model model) {
		 List<Student> students = (List<Student>) repository.findAll();
		
		model.addAttribute("students", students);
		
    	return "students";
    }

    @RequestMapping(value = "add")
    public String addStudent(Model model){
    	model.addAttribute("student", new Student());
        return "addStudent";
    }	
	
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Student student){
        repository.save(student);
    	return "redirect:/students";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String editRemoveEmployee(@PathVariable("id") Long studentId, Model model) {
        repository.deleteById(studentId);
        return "redirect:/students";
    }    
    
    @RequestMapping(value = "getstudents", method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudents() {
            return (List<Student>)repository.findAll();
    }      
}
