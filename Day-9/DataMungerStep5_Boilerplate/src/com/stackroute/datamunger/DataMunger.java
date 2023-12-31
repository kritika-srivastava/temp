package com.stackroute.datamunger;

import com.stackroute.datamunger.query.Query;
import com.stackroute.datamunger.writer.JsonWriter;
import java.util.Scanner;

public class DataMunger {

  public static void main(String[] args) {
    // Read the query from the user
    Scanner kb = new Scanner(System.in);
    String queryString = kb.nextLine();
    kb.close();
    /*
     * Instantiate Query class. This class is responsible for: 1. Parsing the query
     * 2. Select the appropriate type of query processor 3. Get the resultSet which
     * is populated by the Query Processor
     */
    Query query = new Query();
    /*
     * Instantiate JsonWriter class. This class is responsible for writing the
     * ResultSet into a JSON file
     */
    JsonWriter jsonWriter = new JsonWriter();
    jsonWriter.writeToJson(query.executeQuery(queryString));
    /*
     * call executeQuery() method of Query class to get the resultSet. Pass this
     * resultSet as parameter to writeToJson() method of JsonWriter class to write
     * the resultSet into a JSON file
     */

  }
}
