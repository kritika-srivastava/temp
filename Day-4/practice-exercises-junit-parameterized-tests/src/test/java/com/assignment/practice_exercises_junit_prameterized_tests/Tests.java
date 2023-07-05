package com.assignment.practice_exercises_junit_prameterized_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tests {

  private Calculate calc;
  private StringManipulation str;

  @BeforeEach
  public void setUp() {
    calc = new Calculate();
    str = new StringManipulation();
  }

  @AfterEach
  public void tearDown() {
    calc = null;
    str = null;
  }

  //----------------------Tests for Calculate class---------------------------------

  @Test
  void addSumPositivetest() {
    assertEquals(9, calc.addSum(4, 5));
  }

  @Test
  void isEvenPositiveTest() {
    assertEquals(true, calc.isEven(6));
  }

  @Test
  void isEvenNegativeTest() {
    assertEquals(false, calc.isEven(9));
  }

  //----------------------Tests for StringManipulation class---------------------------------

  @Test
  void vowelCountPositiveTest() {
    assertEquals(5, str.vowelCount("Education"));
  }

  @Test
  void nullStringVowelCountTest() {
    assertEquals(0, str.vowelCount(null));
  }

  @Test
  void emptyStringVowelCountTest() {
    assertEquals(0, str.vowelCount(""));
  }

  @Test
  void characterCountPositiveTest() {
    assertEquals(9, str.characterCount("Education"));
  }

  @Test
  void nullStringcharacterCountTest() {
    assertEquals(0, str.characterCount(null));
  }

  @Test
  void emptyStringcharacterCountTest() {
    assertEquals(0, str.characterCount(""));
  }
}
