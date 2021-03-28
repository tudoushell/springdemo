package com.elliot.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author: elliot
 * @Date: 2021/2/25
 */

@Entity
@Table(name = "data_student")
public class Student extends BaseEntity{

  private String name;

  private Integer age;

  @ManyToOne
  @JoinColumn(name = "school_id")
  private School school;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }
}
