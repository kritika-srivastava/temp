package com.stackroute.collections;

import java.util.*;

public class PlayerListService {

  List<Player> playerList;

  public PlayerListService() {
    playerList = new ArrayList<>();
  }

  public List<Player> getPlayerList() {
    return playerList;
  }

  public void addPlayersToList(Player player) {
    playerList.add(player);
  }

  public List<Player> getPlayerListSortedByNameIgnoringCaseInAscendingOrder() {
    Collections.sort(playerList, new PlayerNameComparator());
    return playerList;
  }

  public List<Player> getPlayerListSortedByScoreInDescendingOrder() {
    Collections.sort(playerList, new PlayerScoreComparator());
    System.out.println("<><><><>" + playerList);
    return playerList;
  }

  public List<Player> getPlayerListGreaterThanFiftySortedByScoreInDescendingOrder() {
    List<Player> playerGreaterFifty = new ArrayList<>();
    for (Player p : playerList) {
      if (p.getPlayerScore() > 50) {
        playerGreaterFifty.add(p);
      }
    }
    Collections.sort(playerGreaterFifty, new PlayerScoreComparator());

    return playerGreaterFifty;
  }

  public List<Player> getPlayerListPlayedInSameMatchSortedByNameInAscendingOrder(
    String playerMatch
  ) {
    List<Player> playerSameMatch = new ArrayList<>();
    for (Player p : playerList) {
      if (p.getPlayerMatch().equals(playerMatch)) {
        playerSameMatch.add(p);
      }
    }
    Collections.sort(playerSameMatch, new PlayerNameComparator());
    return playerSameMatch;
  }
}
