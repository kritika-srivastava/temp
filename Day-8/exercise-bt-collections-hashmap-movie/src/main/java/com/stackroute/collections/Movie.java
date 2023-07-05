package com.stackroute.collections;

import java.time.LocalDate;

/*
Movie class has four fields- movieId,movieName, genre and releaseDate
This class should be of Comparable type comparing movies based on releaseDate
 */
public class Movie implements Comparable<Movie> {

  int movieId;
  String movieName;
  String genre;
  LocalDate releaseDate;

  public Movie(
    int movieId,
    String movieName,
    String genre,
    LocalDate releaseDate
  ) {
    this.movieId = movieId;
    this.movieName = movieName;
    this.genre = genre;
    this.releaseDate = releaseDate;
  }

  public int getMovieId() {
    return movieId;
  }

  public String getMovieName() {
    return movieName;
  }

  public String getGenre() {
    return genre;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  //assertTrue(details.contains("movieId=101, movieName=Titanic, genre=Drama"), MESSAGE_TWO);
  //assertTrue(details.contains("releaseDate=1994-08-12"), MESSAGE_TWO);
  @Override
  public String toString() {
    return new String(
      "movieId=" +
      movieId +
      ", movieName=" +
      movieName +
      ", genre=" +
      genre +
      ", releaseDate=" +
      releaseDate.toString()
    );
  }

  @Override
  public int compareTo(Movie anotherMovie) {
    return this.getMovieId() - anotherMovie.getMovieId();
  }
}
