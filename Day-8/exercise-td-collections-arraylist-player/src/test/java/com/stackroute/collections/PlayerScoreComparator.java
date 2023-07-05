package com.stackroute.collections;

import java.util.*;

public class PlayerScoreComparator implements Comparator<Object> {

  public int compare(Object ob1, Object ob2) {
    Player s1 = (Player) ob1;
    Player s2 = (Player) ob2;

    if (s1.getPlayerScore() == s2.getPlayerScore()) {
      if (s1.getPlayerId() < s2.getPlayerId()) {
        return -1;
      } else {
        return 1;
      }
    } else if (s1.getPlayerScore() < s2.getPlayerScore()) {
      return 1;
    }

    return -1;
  }
}
