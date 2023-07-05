package com.stackroute.collections;

import java.time.LocalDate;
import java.util.*;

/*
This class contains a property called movieMap of type Map
This class contains methods for adding key-value pairs of Movie and its rating to HashMap and
various methods for accessing the keys and values based on some conditions
 */
public class MovieService {

  /**
   * Constructor to create movieMap as an empty  LinkedHashMap object
   */
  Map<Movie, Integer> map;

  public MovieService() {
    map = new LinkedHashMap<Movie, Integer>();
  }

  /*
    Returns the movieMap object
     */
  public Map<Movie, Integer> getMovieMap() {
    return map;
  }

  /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
  public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(
    Movie movie,
    Integer rating
  ) {
    map.put(movie, rating);
    return map.entrySet();
  }

  /*
    Return Set of movie names having rating greater than or equal to given rating
     */
  public List<String> getHigherRatedMovieNames(int rating) {
    List<String> highRating = new ArrayList<>();
    for (Movie s : map.keySet()) {
      if (map.get(s) >= rating) {
        highRating.add(s.getMovieName());
      }
    }
    return highRating;
  }

  /*
    Return Set of movie names belonging to specific genre
     */
  public List<String> getMovieNamesOfSpecificGenre(String genre) {
    List<String> movieGenList = new ArrayList<>();
    for (Movie s : map.keySet()) {
      if (s.getGenre().equals(genre)) {
        movieGenList.add(s.getMovieName());
      }
    }
    return movieGenList;
  }

  /*
   Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */

  public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(
    LocalDate releaseDate
  ) {
    List<String> movieGenList = new ArrayList<>();
    for (Movie s : map.keySet()) {
      if (s.getReleaseDate().isAfter(releaseDate) && map.get(s) <= 3) {
        movieGenList.add(s.getMovieName());
      }
    }
    return movieGenList;
  }

  /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
  public List<Movie> getSortedMovieListByReleaseDate() {
    Map<LocalDate, Movie> tree = new TreeMap<>();
    List<Movie> MovieListByReleaseDate = new ArrayList<>();
    for (Movie mov : map.keySet()) {
      tree.put(mov.getReleaseDate(), mov);
    }
    for (LocalDate s : tree.keySet()) {
      MovieListByReleaseDate.add(tree.get(s));
      //System.out.println(s.getMovieName() + "->" + s.getReleaseDate());
    }
    return MovieListByReleaseDate;
  }

  /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
  public Map<Movie, Integer> getSortedMovieListByRating() {
    return sortedHashMapByValues(map);
  }

  static Map<Movie, Integer> sortedHashMapByValues(Map<Movie, Integer> map) {
    List list = new ArrayList(map.entrySet());
    //Custom Comparator
    Collections.sort(
      list,
      new Comparator() {
        public int compare(Object obj1, Object obj2) {
          return ((Comparable) ((Map.Entry) (obj1)).getValue()).compareTo(
              ((Map.Entry) (obj2)).getValue()
            );
        }
      }
    );
    //copying the sorted list in HashMap to preserve the iteration order
    Map sortedHashMap = new LinkedHashMap();
    for (Iterator it = list.iterator(); it.hasNext();) {
      Map.Entry entry = (Map.Entry) it.next();
      sortedHashMap.put(entry.getKey(), entry.getValue());
    }
    return sortedHashMap;
  }
}
