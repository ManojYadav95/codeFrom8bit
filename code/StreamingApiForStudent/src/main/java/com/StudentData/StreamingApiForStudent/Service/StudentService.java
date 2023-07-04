package com.StudentData.StreamingApiForStudent.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentData.StreamingApiForStudent.Entity.Student;
import com.StudentData.StreamingApiForStudent.Repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository srepo;
	
	public ResponseEntity<String> saveData(@RequestBody List<Student> list)
	{
		srepo.saveAll(list);
		return ResponseEntity.ok("Data saved in db");
	}
	
	public ResponseEntity<List<Student>> getData()
	{
		List<Student> list = srepo.findAll();
		return new ResponseEntity
	}
}
