package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import org.junit.jupiter.api.*;

public class StudentMarksTests {

  private StudentMarks student_marks;

  @BeforeEach
  public void setUp() {
    student_marks = new StudentMarks();
  }

  @AfterEach
  public void tearDown() {
    student_marks = null;
  }

  @Test
  public void testAddThreeIntegerMarks() {
    assertEquals(180, student_marks.calculateMarks(50, 60, 70));
  }

  @Test
  public void testAddFourIntegerMarks() {
    assertEquals(260, student_marks.calculateMarks(50, 60, 70, 80));
  }

  @Test
  public void testAddFiveFloatMarks() {
    assertEquals(
      50.0f,
      StudentMarks.calculateMarks(10.0f, 10.0f, 10.0f, 10.0f, 10.0f)
    );
  }

  @Test
  public void testAddFourDoubleMarks() {
    assertEquals(251, student_marks.calculateMarks(70.0, 80.5, 54.7, 45.8));
  }

  @Test
  public void testAddFourFloatMarks() {
    assertEquals(
      251.0f,
      student_marks.calculateMarks(70.0f, 80.5f, 54.7f, 45.8f)
    );
  }

  @Test
  public void testClassifyStudentGradeSetTrue() {
    Set<Integer> classifyPositive = new HashSet<Integer>();
    classifyPositive.addAll(
      Arrays.asList(new Integer[] { 91, 93, 92, 94, 98, 99, 90 })
    );
    assertEquals(
      "GRADE A",
      StudentMarks.classifyStudentGrade(classifyPositive)
    );
  }

  @Test
  public void testClassifyStudentGradeSetFalse() {
    Set<Integer> classifyNegative = new HashSet<Integer>();
    classifyNegative.addAll(
      Arrays.asList(new Integer[] { 91, 93, 92, 94, 99, 90 })
    );
    assertEquals(
      "not Grade A",
      StudentMarks.classifyStudentGrade(classifyNegative)
    );
  }

  @Test
  public void testClassifyStudentGradeListTrue() {
    List<Integer> classifyPositive = new LinkedList<>();
    classifyPositive.addAll(
      Arrays.asList(new Integer[] { 91, 93, 80, 92, 94, 99, 90 })
    );
    assertEquals(
      "GRADE B",
      StudentMarks.classifyStudentGrade(classifyPositive)
    );
  }

  @Test
  public void testClassifyStudentGradeListFalse() {
    List<Integer> classifyNegative = new LinkedList<>();
    classifyNegative.addAll(
      Arrays.asList(new Integer[] { 91, 93, 92, 94, 99, 90 })
    );
    assertEquals(
      "not Grade B",
      StudentMarks.classifyStudentGrade(classifyNegative)
    );
  }

  @Test
  public void testClassifyStudentGradeCollectionTrue() {
    Collection<Integer> classifyPositive = new Vector<>();
    classifyPositive.addAll(
      Arrays.asList(new Integer[] { 91, 93, 80, 70, 92, 94, 99, 90 })
    );
    assertEquals(
      "GRADE C",
      StudentMarks.classifyStudentGrade(classifyPositive)
    );
  }

  @Test
  public void testClassifyStudentGradeListCollection() {
    Collection<Integer> classifyNegative = new Vector<>();
    classifyNegative.addAll(Arrays.asList(new Integer[] { 91 }));
    assertEquals("None", StudentMarks.classifyStudentGrade(classifyNegative));
  }
}
