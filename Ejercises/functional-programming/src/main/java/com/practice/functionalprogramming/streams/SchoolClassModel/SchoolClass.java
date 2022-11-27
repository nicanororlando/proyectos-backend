package com.practice.functionalprogramming.streams.SchoolClassModel;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

  private String name;
  private List<Student> students;

  public SchoolClass() {}

  public SchoolClass(String name) {
    this.name = name;
    this.students = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public void merge(SchoolClass classToMerge) {
    this.students.addAll(classToMerge.getStudents());
  }
}
