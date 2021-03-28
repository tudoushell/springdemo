package com.elliot.jpa.repository;

import com.elliot.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: elliot
 * @Date: 2021/2/25
 */
public interface StudentRepository extends JpaRepository<Student, String> {
}
