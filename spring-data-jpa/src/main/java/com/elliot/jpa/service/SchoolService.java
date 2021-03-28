package com.elliot.jpa.service;

import com.elliot.jpa.domain.School;
import com.elliot.jpa.domain.Student;
import com.elliot.jpa.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: elliot
 * @Date: 2021/2/25
 */
@Service
public class SchoolService {

  @Autowired
  private SchoolRepository schoolRepository;

  @Transactional(rollbackFor = Exception.class)
  public void save() {
    School school = new School();
    school.setName("AAA");
    school.setAddress("addd");

    Student student = new Student();
    student.setName("mikde");
    student.setAge(12);

    Student student1 = new Student();
    student1.setName("tom");
    student1.setAge(13);

    List<Student> students = new ArrayList<>();
    students.add(student);
    students.add(student1);

    school.setStudentList(students);

    schoolRepository.save(school);
  }
}
