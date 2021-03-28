package com.elliot.jpa.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: elliot
 * @Date: 2021/2/25
 */
@Entity
@Table(name = "data_school")
public class School extends BaseEntity {

  private String name;

  private String address;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
  private List<Student> studentList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }
}
