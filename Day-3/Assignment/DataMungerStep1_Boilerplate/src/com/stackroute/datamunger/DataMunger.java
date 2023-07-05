package com.stackroute.datamunger;

/*There are total 5 DataMungertest files:
 *
 * 1)DataMungerTestTask1.java file is for testing following 3 methods
 * a)getSplitStrings()  b) getFileName()  c) getBaseQuery()
 *
 * Once you implement the above 3 methods,run DataMungerTestTask1.java
 *
 * 2)DataMungerTestTask2.java file is for testing following 3 methods
 * a)getFields() b) getConditionsPartQuery() c) getConditions()
 *
 * Once you implement the above 3 methods,run DataMungerTestTask2.java
 *
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getLogicalOperators() b) getOrderByFields()
 *
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 *
 * 4)DataMungerTestTask4.java file is for testing following 2 methods
 * a)getGroupByFields()  b) getAggregateFunctions()
 *
 * Once you implement the above 2 methods,run DataMungerTestTask4.java
 *
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */

public class DataMunger {

  /*
   * This method will split the query string based on space into an array of words
   * and display it on console
   */

  public String[] getSplitStrings(String queryString) {
    return queryString.toLowerCase().split(" ");
  }

  /*
   * Extract the name of the file from the query. File name can be found after a
   * space after "from" clause. Note: ----- CSV file can contain a field that
   * contains from as a part of the column name. For eg: from_date,from_hrs etc.
   *
   * Please consider this while extracting the file name in this method.
   */

  public String getFileName(String queryString) {
    String file_name = "";
    String[] query_parts = queryString.split(" ");

    for (int i = 0; i < query_parts.length; i++) {
      if (query_parts[i].equals("from")) {
        file_name = query_parts[i + 1];
        break;
      } else {}
    }

    return file_name;
  }

  /*
   * This method is used to extract the baseQuery from the query string. BaseQuery
   * contains from the beginning of the query till the where clause
   *
   * Note: ------- 1. The query might not contain where clause but contain order
   * by or group by clause 2. The query might not contain where, order by or group
   * by clause 3. The query might not contain where, but can contain both group by
   * and order by clause
   */

  public String getBaseQuery(String queryString) {
    String[] query_parts = new DataMunger().getSplitStrings(queryString);
    int i = 0;
    for (i = 0; i < query_parts.length; i++) {
      if (query_parts[i].equals("from")) {
        i += 1;
        break;
      } else {}
    }
    String base_query = "";
    for (int j = 0; j <= i; j++) {
      base_query += query_parts[j] + " ";
    }
    return base_query.trim();
  }

  /*
   * This method will extract the fields to be selected from the query string. The
   * query string can have multiple fields separated by comma. The extracted
   * fields will be stored in a String array which is to be printed in console as
   * well as to be returned by the method
   *
   * Note: 1. The field name or value in the condition can contain keywords
   * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The field
   * name can contain '*'
   *
   */

  public String[] getFields(String queryString) {
    String[] query_parts = new DataMunger().getSplitStrings(queryString);
    return query_parts[1].split(",");
  }

  /*
   * This method is used to extract the conditions part from the query string. The
   * conditions part contains starting from where keyword till the next keyword,
   * which is either group by or order by clause. In case of absence of both group
   * by and order by clause, it will contain till the end of the query string.
   * Note:  1. The field name or value in the condition can contain keywords
   * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
   * might not contain where clause at all.
   */

  public String getConditionsPartQuery(String queryString) {
    String[] query_parts = new DataMunger().getSplitStrings(queryString);
    boolean flag = false;
    String part_query = "";
    fd:for (int i = 0; i < query_parts.length; i++) {
      if (query_parts[i].equals("from") && !flag) {
        i += 1;
        flag = true;
        continue fd;
      } else if (query_parts[i].equals("where")) {
        continue fd;
      } else if (
        query_parts[i].equals("order") || query_parts[i].equals("group")
      ) {
        break;
      } else if (flag) {
        part_query += query_parts[i] + " ";
      } else {}
    }
    if (part_query.trim().length() > 0) {
      return part_query.trim().toLowerCase();
    }
    return null;
  }

  /*
   * This method will extract condition(s) from the query string. The query can
   * contain one or multiple conditions. In case of multiple conditions, the
   * conditions will be separated by AND/OR keywords. for eg: Input: select
   * city,winner,player_match from ipl.csv where season > 2014 and city
   * ='Bangalore'
   *
   * This method will return a string array ["season > 2014","city ='bangalore'"]
   * and print the array
   *
   * Note: ----- 1. The field name or value in the condition can contain keywords
   * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
   * might not contain where clause at all.
   */

  public String[] getConditions(String queryString) {
    String part_condition_query = new DataMunger()
    .getConditionsPartQuery(queryString);
    if (part_condition_query == null) {
      return null;
    }

    if (part_condition_query.length() > 0) {
      String[] condition = part_condition_query
        .toLowerCase()
        .split("( and )|( or )");

      if (part_condition_query.length() > 0) {
        return condition;
      }
    } else {}
    return null;
  }

  /*
   * This method will extract logical operators(AND/OR) from the query string. The
   * extracted logical operators will be stored in a String array which will be
   * returned by the method and the same will be printed Note:  1. AND/OR
   * keyword will exist in the query only if where conditions exists and it
   * contains multiple conditions. 2. AND/OR can exist as a substring in the
   * conditions as well. For eg: name='Alexander',color='Red' etc. Please consider
   * these as well when extracting the logical operators.
   *
   */

  public String[] getLogicalOperators(String queryString) {
    String part_condition_query = new DataMunger()
    .getConditionsPartQuery(queryString);
    if (part_condition_query == null) {
      return null;
    }
    String operator = "";
    String[] condition = part_condition_query.split(" ");
    for (String str : condition) {
      if (str.equals("and") || str.equals("or")) {
        operator += (str) + " ";
      }
    }
    if (operator.length() > 0) {
      return operator.split(" ");
    }

    return null;
  }

  /*
   * This method extracts the order by fields from the query string. Note:
   * 1. The query string can contain more than one order by fields. 2. The query
   * string might not contain order by clause at all. 3. The field names,condition
   * values might contain "order" as a substring. For eg:order_number,job_order
   * Consider this while extracting the order by fields
   */

  public String[] getOrderByFields(String queryString) {
    String[] query = queryString.split(" ");
    int i = 0;
    for (i = 0; i < query.length; i++) {
      if (query[i].equals("order")) {
        i += 2;
        break;
      } else {}
    }
    String order_by_fields = "";
    for (; i < query.length; i++) {
      if (query[i].equals("group")) {
        break;
      }
      order_by_fields += query[i] + " ";
    }
    order_by_fields = order_by_fields.toLowerCase().trim();

    if (order_by_fields != "") {
      return order_by_fields.split(" ");
    }
    return null;
  }

  /*
   * This method extracts the group by fields from the query string. Note:
   * 1. The query string can contain more than one group by fields. 2. The query
   * string might not contain group by clause at all. 3. The field names,condition
   * values might contain "group" as a substring. For eg: newsgroup_name
   *
   * Consider this while extracting the group by fields
   */

  public String[] getGroupByFields(String queryString) {
    String[] query = queryString.split(" ");
    int i = 0;
    for (i = 0; i < query.length; i++) {
      if (query[i].equals("group")) {
        i += 2;
        break;
      }
    }
    String group_by_fields = "";
    for (; i < query.length; i++) {
      if (query[i].equals("order")) {
        break;
      }
      group_by_fields += query[i] + " ";
    }
    group_by_fields.toLowerCase().trim();

    if (group_by_fields.length() > 0) {
      return group_by_fields.split(" ");
    }
    return null;
  }

  /*
   * This method extracts the aggregate functions from the query string. Note:
   *  1. aggregate functions will start with "sum"/"count"/"min"/"max"/"avg"
   * followed by "(" 2. The field names might
   * contain"sum"/"count"/"min"/"max"/"avg" as a substring. For eg:
   * account_number,consumed_qty,nominee_name
   *
   * Consider this while extracting the aggregate functions
   */

  public String[] getAggregateFunctions(String queryString) {
    String[] query = queryString.split(" ");
    String agg = "";
    for (String i : query) {
      String[] sub_agg = i.split(",");
      for (String j : sub_agg) {
        if (
          (j.contains("sum") && (j.charAt(j.indexOf("sum") + 3) == '(')) ||
          (j.contains("count") && (j.charAt(j.indexOf("count") + 5) == '(')) ||
          (j.contains("avg") && (j.charAt(j.indexOf("avg") + 3) == '(')) ||
          (j.contains("max") && (j.charAt(j.indexOf("max") + 3) == '(')) ||
          (j.contains("min") && (j.charAt(j.indexOf("min") + 3) == '('))
        ) {
          agg += j + " ";
        }
      }
    }
    agg = agg.trim();

    if (agg.length() > 0) {
      return agg.split(" ");
    }
    return null;
  }
}
