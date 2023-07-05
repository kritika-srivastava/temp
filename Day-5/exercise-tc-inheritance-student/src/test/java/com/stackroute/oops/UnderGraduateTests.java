package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnderGraduateTests {

  private UnderGraduate ug;

  @BeforeEach
  public void setup() {
    ug = new UnderGraduate(1, "Kritika", 91.0, 21, "xyz");
  }

  @AfterEach
  public void teardown() {
    ug = null;
  }

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
}
