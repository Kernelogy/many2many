package com.example.orm.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private int employeeId;
	private String name;
	private String email;
	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "employees_projects", 
//			joinColumns = @JoinColumn(referencedColumnName = "employee_id"), 
//			inverseJoinColumns = @JoinColumn(referencedColumnName = "project_id")
//			)
	private Set<Project> projects;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	

}
