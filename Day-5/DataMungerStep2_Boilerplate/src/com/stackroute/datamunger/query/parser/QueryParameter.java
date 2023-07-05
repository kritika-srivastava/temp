package com.stackroute.datamunger.query.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This class will contain the elements of the parsed Query String such as conditions,
 * logical operators,aggregate functions, file name, fields group by fields, order by
 * fields, Query Type
 * */

public class QueryParameter {

  String query;

  public void getQuery(String query) {
    this.query = query;
  }

  public String getFileName() {
    String fileName = "";
    String[] queryParts = query.split(" ");

    for (int i = 0; i < queryParts.length; i++) {
      if (queryParts[i].equals("from")) {
        fileName = queryParts[i + 1];
        break;
      }
    }

    return fileName;
  }

  public String getBaseQuery() {
    String[] queryParts = query.split(" ");
    int i = 0;
    for (i = 0; i < queryParts.length; i++) {
      if (queryParts[i].equals("from")) {
        i += 1;
        break;
      }
    }
    String baseQuery = "";
    for (int j = 0; j <= i; j++) {
      baseQuery += queryParts[j] + " ";
    }
    return baseQuery.trim();
  }

  public String getConditionsPartQuery(String queryString) {
    String[] queryParts = queryString.split(" ");
    boolean flag = false;
    String partQuery = "";
    fd:for (int i = 0; i < queryParts.length; i++) {
      if (queryParts[i].equals("from") && !flag) {
        i += 1;
        flag = true;
        continue fd;
      } else if (queryParts[i].equals("where")) {
        continue fd;
      } else if (
        queryParts[i].equals("order") || queryParts[i].equals("group")
      ) {
        break;
      } else if (flag) {
        partQuery += queryParts[i] + " ";
      }
    }
    if (partQuery.trim().length() > 0) {
      return partQuery.trim();
    }
    return null;
  }

  public List<Restriction> getRestrictions() {
    List<Restriction> restr = new ArrayList<>();
    String partConditionQuery = new QueryParameter()
    .getConditionsPartQuery(query);
    if (partConditionQuery == null) {
      return null;
    }

    if (partConditionQuery.length() > 0) {
      String[] condition = partConditionQuery.split("( and )|( or )");

      for (String j : condition) {
        String[] val = j.split("[ ']");

        restr.add(new Restriction(val[0], val[2], val[1]));
      }

      if (restr.size() > 0) {
        return restr;
      }
    }
    return null;
  }

  public List<String> getLogicalOperators() {
    List<String> operator = new ArrayList<>();
    String partConditionQuery = new QueryParameter()
    .getConditionsPartQuery(query);
    if (partConditionQuery == null) {
      return null;
    }

    String[] condition = partConditionQuery.split(" ");
    for (String str : condition) {
      if (str.toLowerCase().equals("and") || str.toLowerCase().equals("or")) {
        operator.add(str);
      }
    }
    if (operator.size() > 0) {
      return operator;
    }

    return null;
  }

  public List<String> getFields() {
    String[] queryParts = query.split(" ");
    List<String> ret = new ArrayList<>();
    Collections.addAll(ret, queryParts[1].split(","));
    return ret;
  }

  public List<AggregateFunction> getAggregateFunctions() {
    String[] q = query.split(" ");
    List<AggregateFunction> aggRet = new ArrayList<>();

    for (String i : q) {
      String[] subAgg = i.split(",");
      for (String j : subAgg) {
        if (j.contains("sum") && (j.charAt(j.indexOf("sum") + 3) == '(')) {
          aggRet.add(
            new AggregateFunction(
              j.substring(j.indexOf("sum") + 4, j.length() - 1),
              "sum"
            )
          );
        } else if (
          j.contains("count") && (j.charAt(j.indexOf("count") + 5) == '(')
        ) {
          aggRet.add(
            new AggregateFunction(
              j.substring(j.indexOf("count") + 6, j.length() - 1),
              "count"
            )
          );
        } else if (
          j.contains("avg") && (j.charAt(j.indexOf("avg") + 3) == '(')
        ) {
          aggRet.add(
            new AggregateFunction(
              j.substring(j.indexOf("avg") + 4, j.length() - 1),
              "avg"
            )
          );
        } else if (
          j.contains("max") && (j.charAt(j.indexOf("max") + 3) == '(')
        ) {
          aggRet.add(
            new AggregateFunction(
              j.substring(j.indexOf("max") + 4, j.length() - 1),
              "max"
            )
          );
        } else if (
          j.contains("min") && (j.charAt(j.indexOf("min") + 3) == '(')
        ) {
          aggRet.add(
            new AggregateFunction(
              j.substring(j.indexOf("min") + 4, j.length() - 1),
              "min"
            )
          );
        }
      }
    }

    if (aggRet.size() > 0) {
      return aggRet;
    }
    return null;
  }

  public List<String> getGroupByFields() {
    List<String> ret = new ArrayList<String>();
    String[] q = query.split(" ");
    int i = 0;
    for (i = 0; i < q.length; i++) {
      if (q[i].equals("group")) {
        i += 2;
        break;
      }
    }

    for (; i < q.length; i++) {
      if (q[i].equals("order")) {
        break;
      }
      ret.add(q[i]);
    }

    if (ret.size() > 0) {
      return ret;
    }
    return null;
  }

  public List<String> getOrderByFields() {
    List<String> ret = new ArrayList<String>();
    String[] q = query.split(" ");
    int i = 0;
    for (i = 0; i < q.length; i++) {
      if (q[i].equals("order")) {
        i += 2;
        break;
      }
    }

    for (; i < q.length; i++) {
      if (q[i].equals("group")) {
        break;
      }
      ret.add(q[i]);
    }

    if (ret.size() > 0) {
      return ret;
    }
    return null;
  }
}
