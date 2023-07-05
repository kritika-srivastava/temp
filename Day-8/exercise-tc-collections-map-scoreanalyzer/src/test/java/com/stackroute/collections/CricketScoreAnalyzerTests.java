package com.stackroute.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CricketScoreAnalyzerTests {

  private CricketScoreAnalyzer analyze;
  private Map<String, Integer> score;

  @BeforeEach
  public void setUp() {
    analyze = new CricketScoreAnalyzer();
    analyze.addRunsToScoreCard("Sachin", 102);
    analyze.addRunsToScoreCard("Dhoni", 78);
    analyze.addRunsToScoreCard("Kohli", 107);

    score = new HashMap<>();
    score.put("Sachin", 102);
    score.put("Dhoni", 78);
    score.put("Kohli", 107);
  }

  @AfterEach
  public void tearDown() {
    analyze = null;
    score = null;
  }

  @Test
  void testAddRunsScoredTrue() {
    assertEquals(true, analyze.addRunsToScoreCard("Rohit", 110));
  }

  @Test
  void testAddRunsScoredFalse() {
    assertEquals(false, analyze.addRunsToScoreCard(null, 110));
  }

  @Test
  void testGetRunsScored() {
    assertEquals(102, analyze.getRunsScored("Sachin"));
  }

  @Test
  void testGetRunsScoredFalse() {
    assertNotEquals(100, analyze.getRunsScored("Sachin"));
  }

  @Test
  void testGetTotalRunsScored() {
    assertEquals(287, analyze.getTotalRuns());
  }

  @Test
  void testGetTotalRunsScoredFalse() {
    assertNotEquals(280, analyze.getTotalRuns());
  }

  @Test
  void testGetSortedBatsmanName() {
    List<String> batsman = new ArrayList<>();
    batsman.add("Sachin");
    batsman.add("Kohli");
    batsman.add("Dhoni");

    assertEquals(batsman.toString(), analyze.getSortedBatsmanName().toString());
  }

  @Test
  void testGetHighestRunsScored() {
    assertEquals(107, analyze.getHighestRunsScored());
  }

  @Test
  void testGetBatsmenNamesWithHighestRuns() {
    List<String> batsman = new ArrayList<>();
    batsman.add("Kohli");
    assertEquals(batsman, analyze.getBatsmenNamesWithHighestRuns());
  }

  @Test
  void testGetScorecard() {
    assertEquals(score.toString(), analyze.getScoreCard().toString());
  }
}
