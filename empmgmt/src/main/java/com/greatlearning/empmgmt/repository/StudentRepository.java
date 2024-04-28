package com.greatlearning.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.empmgmt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
