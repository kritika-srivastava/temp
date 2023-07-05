package com.stackroute.collections;

public class Player {

  int playerId;
  String playerName;
  int playerScore;
  String playerMatch;

  public Player() {
    playerId = -1;
    playerName = null;
    playerScore = 0;
    playerMatch = null;
  }

  public Player(
    int playerId,
    String playerName,
    int playerScore,
    String playerMatch
  ) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.playerScore = playerScore;
    this.playerMatch = playerMatch;
  }

  public int getPlayerId() {
    return playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getPlayerScore() {
    return playerScore;
  }

  public String getPlayerMatch() {
    return playerMatch;
  }

  @Override
  public String toString() {
    return new String(
      "[playerId=" +
      this.getPlayerId() +
      ", playerName=" +
      this.getPlayerName() +
      ", playerScore=" +
      this.getPlayerScore() +
      ",playerMatch=" +
      this.getPlayerMatch() +
      "]"
    );
  }
}
