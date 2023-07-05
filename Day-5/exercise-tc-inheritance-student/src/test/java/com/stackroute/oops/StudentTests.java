package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTests {

  private UnderGraduate ug;
  private PostGraduate pg;

  @BeforeEach
  public void setup() {
    ug = new UnderGraduate(1, "Kritika", 91.0, 21, "xyz");
    pg = new PostGraduate(2, "Ruchi", 61.0, 21, "abc");
  }

  @AfterEach
  public void teardown() {
    ug = null;
    pg = null;
  }

  // Checking for child class UnderGraduate.java---------------------------------------------------
  @Test
  void checkUnderGraduateGetStudentID() {
    assertEquals(1, ug.getStudentId());
  }

  @Test
  void checkUnderGraduateGetName() {
    assertEquals("Kritika", ug.getName());
  }

  @Test
  void checkUnderGraduateGetGrade() {
    assertEquals(91.0, ug.getGrade());
  }

  @Test
  void checkUnderGraduateGetAge() {
    assertEquals(21, ug.getAge());
  }

  @Test
  void checkUnderGraduateGetAddress() {
    assertEquals("xyz", ug.getAddress());
  }

  @Test
  void checkUGToString() {
    assertEquals(
      "Student{studentId=1, name='Kritika', grade=91.0, age=21, address='xyz'} Passed=true",
      ug.toString()
    );
  }

  // Checking for child class PostGraduate.java---------------------------------------------------
  @Test
  void checkPostGraduateGetStudentID() {
    assertEquals(2, pg.getStudentId());
  }

  @Test
  void checkPostGraduateGetName() {
    assertEquals("Ruchi", pg.getName());
  }

  @Test
  void checkPostGraduateGetGrade() {
    assertEquals(61.0, pg.getGrade());
  }

  @Test
  void checkPostGraduateGetAge() {
    assertEquals(21, pg.getAge());
  }

  @Test
  void checkPostGraduateGetAddress() {
    assertEquals("abc", pg.getAddress());
  }

  @Test
  void checkPGToString() {
    assertEquals(
      "Student{studentId=2, name='Ruchi', grade=61.0, age=21, address='abc'} Passed=false",
      pg.toString()
    );
  }
}
