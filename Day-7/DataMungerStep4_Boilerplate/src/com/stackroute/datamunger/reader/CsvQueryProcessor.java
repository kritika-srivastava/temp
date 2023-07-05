package com.stackroute.datamunger.reader;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvQueryProcessor extends QueryProcessingEngine {

  String fileName;

  /*
   * parameterized constructor to initialize filename. As you are trying to
   * perform file reading, hence you need to be ready to handle the IO Exceptions.
   */
  public CsvQueryProcessor(String fileName) throws FileNotFoundException {
    if (
      fileName == null || fileName.isBlank() || new FileReader(fileName) == null
    ) {
      throw new FileNotFoundException();
    }

    this.fileName = fileName;
  }

  /*
   * implementation of getHeader() method. We will have to extract the headers
   * from the first line of the file.
   */
  @Override
  public Header getHeader() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    int k = 0;
    Header ret = new Header();
    while (k == 0) {
      ret = new Header(reader.readLine());
      k++;
    }
    reader.close();
    return ret;
  }

  /**
   * This method will be used in the upcoming assignments
   */
  @Override
  public void getDataRow() {}

  /*
   * implementation of getColumnType() method. To find out the data types, we will
   * read the first line from the file and extract the field values from it. In
   * the previous assignment, we have tried to convert a specific field value to
   * Integer or Double. However, in this assignment, we are going to use Regular
   * Expression to find the appropriate data type of a field. Integers: should
   * contain only digits without decimal point Double: should contain digits as
   * well as decimal point Date: Dates can be written in many formats in the CSV
   * file. However, in this assignment,we will test for the following date
   * formats('dd/mm/yyyy',
   * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
   */
  @Override
  public DataTypeDefinitions getColumnType() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line = "";
    int k = 0;
    while (k <= 1) {
      line = reader.readLine();
      k++;
    }
    String[] columnTypes = line.split(",");
    String[] dataTypes = new String[columnTypes.length + 1];
    dataTypes[columnTypes.length] = "java.lang.Object";

    for (int i = 0; i < columnTypes.length; i++) {
      // checking for Integer
      if (columnTypes[i].trim().matches("[0-9]+")) {
        dataTypes[i] = "java.lang.Integer";
      }
      // checking for floating point numbers
      else if (columnTypes[i].trim().matches("[-+]?[0-9]*\\.?[0-9]+")) {
        dataTypes[i] = "java.lang.Float";
      }
      // checking for date format
      else if (
        columnTypes[i].trim().matches("[0-9]{4}[-]*[0-9]{2}[-]*[0-9]{2}")
      ) {
        dataTypes[i] = "java.util.Date";
      } else {
        dataTypes[i] = "java.lang.String";
      }
      System.out.println(columnTypes[i] + "-------> " + dataTypes[i]);
    }
    DataTypeDefinitions data = new DataTypeDefinitions(dataTypes);
    return data;
  }
}
