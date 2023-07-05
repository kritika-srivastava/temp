package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTests {

  @BeforeEach
  public void setup() {
    ss = new StudentService();
  }

  @AfterEach
  public void teardown() {
    ss = null;
  }

  private StudentService ss;

  @Test
  void checkCreateUnderGraduateStudent() {
    assertEquals(
      new UnderGraduate(1, "Kritika", 91.0, 21, "xyz").toString(),
      ss.createUnderGraduateStudent(1, "Kritika", 91.0, 21, "xyz").toString()
    );
  }

  @Test
  void checkCreatePostGraduateStudent() {
    assertEquals(
      new PostGraduate(2, "Ruchi", 61.0, 21, "abc").toString(),
      ss.createPostGraduateStudent(2, "Ruchi", 61.0, 21, "abc").toString()
    );
  }
}
