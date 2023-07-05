package com.stackroute.datamunger.reader;

import com.stackroute.datamunger.query.DataSet;
import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Filter;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.query.Row;
import com.stackroute.datamunger.query.RowDataTypeDefinitions;
import com.stackroute.datamunger.query.parser.QueryParameter;
import java.io.*;
import java.util.*;

public class CsvQueryProcessor implements QueryProcessingEngine {

  /*
   * This method will take QueryParameter object as a parameter which contains the
   * parsed query and will process and populate the ResultSet
   */
  public DataSet getResultSet(QueryParameter queryParameter) {
    /*
     * initialize BufferedReader to read from the file which is mentioned in
     * QueryParameter. Consider Handling Exception related to file reading.
     */
    try {
      FileReader fileReader = new FileReader(queryParameter.getFileName());
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String[] headers = bufferedReader.readLine().split(",");
      bufferedReader.mark(1);

      String[] fields = bufferedReader.readLine().split(",", headers.length);

      Header headerMap = new Header();
      for (int i = 0; i < headers.length; i++) {
        headerMap.put(headers[i].trim(), i);
      }
      //DataTypeDefinitions d=new DataTypeDefinitions();
      RowDataTypeDefinitions rowDataTypeDefinitionMap = new RowDataTypeDefinitions();
      for (int i = 0; i < fields.length; i++) {
        rowDataTypeDefinitionMap.put(
          i,
          (String) DataTypeDefinitions.getDataType(fields[i])
        );
      }

      bufferedReader.reset();
      DataSet dataSet = new DataSet();
      long setRowIndex = 1;
      Filter filter = new Filter();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] rowFields = line.split(",", headers.length);
        boolean result = false;
        ArrayList<Boolean> bools = new ArrayList<Boolean>();
        if (queryParameter.getRestrictions() == null) result = true; else {
          for (int i = 0; i < queryParameter.getRestrictions().size(); i++) {
            int index = headerMap.get(
              queryParameter.getRestrictions().get(i).getPropertyName()
            );
            bools.add(
              filter.evaluateExpression(
                queryParameter.getRestrictions().get(i),
                rowFields[index].trim(),
                rowDataTypeDefinitionMap.get(index)
              )
            );
          }
          result = solveOperators(bools, queryParameter.getLogicalOperators());
        }
        if (result) {
          Row rowMap = new Row();
          for (int i = 0; i < queryParameter.getFields().size(); i++) {
            if (queryParameter.getFields().get(i).equals("*")) {
              for (int j = 0; j < rowFields.length; j++) {
                rowMap.put(headers[j].trim(), rowFields[j]);
              }
            } else {
              rowMap.put(
                queryParameter.getFields().get(i),
                rowFields[headerMap.get(queryParameter.getFields().get(i))]
              );
            }
          }
          dataSet.put(setRowIndex++, rowMap);
        }
      }
      bufferedReader.close();

      return dataSet;
    } catch (Exception e) {
      return null;
    }
  }

  private boolean solveOperators(
    ArrayList<Boolean> bools,
    List<String> operators
  ) {
    if (bools.size() == 1) {
      return bools.get(0);
    } else if (bools.size() == 2) {
      if (operators.get(0).matches("AND|and")) return (
        bools.get(0) & bools.get(1)
      ); else return bools.get(0) | bools.get(1);
    } else if (bools.size() == 3) {
      int i = operators.indexOf("AND|and");
      if (i < 0) return bools.get(0) | bools.get(1) | bools.get(2); else if (
        i == 0
      ) return bools.get(0) & bools.get(1) | bools.get(2); else if (
        i == 1
      ) return bools.get(0) | bools.get(1) & bools.get(2); else return false;
    } else return false;
  }
}
