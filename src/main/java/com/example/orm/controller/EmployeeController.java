package com.example.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orm.model.Employee;
import com.example.orm.model.Project;
import com.example.orm.repo.EmployeeRepo;
import com.example.orm.repo.ProjectRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private ProjectRepo projectRepo;
	
	@PostMapping("/saveEmployeeWithProjects")
	public ResponseEntity<?> saveEmployeeWithProjects(@RequestBody Employee employee){
		Employee savedEntity = employeeRepo.saveAndFlush(employee);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(savedEntity);
	}
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<?> getEmployee(@PathVariable int employeeId){
		Employee employee = employeeRepo.findById(employeeId).get();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employee);
		
	}
	@PostMapping("/saveAnEmployeeUnderProject/{projectId}")
	public ResponseEntity<?> saveAnEmployeeUnderProject(@PathVariable int projectId, @RequestBody Employee employee){
		Project project = projectRepo.findById(projectId).get();
		project.getEmployees().add(employee);
		projectRepo.saveAndFlush(project);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(project);
		
	}
}
