package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostGraduateTests {

  private PostGraduate pg;

  @BeforeEach
  public void setup() {
    pg = new PostGraduate(2, "Ruchi", 61.0, 21, "abc");
  }

  @AfterEach
  public void teardown() {
    pg = null;
  }

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
