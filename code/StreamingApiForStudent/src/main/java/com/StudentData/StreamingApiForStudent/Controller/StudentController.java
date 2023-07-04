package com.StudentData.StreamingApiForStudent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentData.StreamingApiForStudent.Entity.Student;
import com.StudentData.StreamingApiForStudent.Service.StudentService;

@RestController
@RequestMapping("/home")
public class StudentController 
{
	@Autowired
	StudentService sservice;
	
	@PostMapping("/post")
	ResponseEntity<String> saveData(@RequestBody List<Student> list)
	{
		return sservice.saveData(list);
	}
	
	@GetMapping("/get")
	ResponseEntity<List<Student>> getData()
	{
		return sservice.getData();
	}
}
