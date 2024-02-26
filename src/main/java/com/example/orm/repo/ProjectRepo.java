package com.example.orm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orm.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
