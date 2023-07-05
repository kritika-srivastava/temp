package com.assignmentxmlconfig;

public class Movie {

  Actor actor;

  public Movie(Actor actor) {
    super();
    this.actor = actor;
  }

  public Movie() {}

  @Override
  public String toString() {
    return "Movie [actor=" + actor + "]";
  }
}
