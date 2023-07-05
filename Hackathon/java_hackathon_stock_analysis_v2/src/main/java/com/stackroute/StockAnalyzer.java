package com.stackroute;

import com.stackroute.exception.InvalidDateException;
import com.stackroute.exception.NoRecordFoundException;
import com.stackroute.exception.StockRecordNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class StockAnalyzer {

  private StockRecord[] stockRecordList;
  private String filePath;

  /**
   * Complete the constructor
   */
  public StockAnalyzer(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Complete the Setters and Getters
   */
  public StockRecord[] getStockRecordList() {
    return stockRecordList;
  }

  public void setStockRecordList(StockRecord[] stockRecordList) {
    this.stockRecordList = stockRecordList;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  /**
   * This method is used to find the number of records from the file excluding the header
   * If any record, doesn't have all the fields, it should be skipped and not counted.
   * If no valid records are found in the file, then NoRecordFoundException should be thrown
   * Assume that every file will have a valid header
   */
  public int validStockRecordCount()
    throws FileNotFoundException, NoRecordFoundException {
    try (Scanner kb = new Scanner(new File(filePath))) {} catch (Exception e) {
      throw new FileNotFoundException();
    }
    Scanner kb = new Scanner(new File(filePath));
    kb.useDelimiter(",");
    boolean header = false;

    int record_length = 0;
    while (kb.hasNext()) {
      if (!header) {
        header = true;
        kb.nextLine();
      } else {
        String line = (kb.nextLine());
        String l[] = line.split(",");

        if (l.length == 7) {
          record_length++;
        }
      }
    }
    if (record_length == 0) {
      throw new NoRecordFoundException();
    }
    return record_length;
  }

  /* This method is responsible to read from the file and load the array stockRecordList with valid Records*/
  public void loadRecordsFromFile()
    throws IOException, ParseException, NoRecordFoundException {
    if (validStockRecordCount() == 0) {
      throw new NoRecordFoundException();
    }
    stockRecordList = new StockRecord[validStockRecordCount()];
    int i = 0;
    Scanner kb = new Scanner(new File(filePath));

    kb.useDelimiter(",");
    boolean header = false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    while (kb.hasNext()) {
      if (!header) {
        header = true;
        kb.nextLine();
      } else {
        String line = (kb.nextLine());
        String l[] = line.split(",");

        if (l.length == 7) {
          //System.out.println(">>>" + l[0] + "<<<<<");

          stockRecordList[i] =
            new StockRecord(
              formatter.parse(l[0]),
              Double.parseDouble(l[1]),
              Double.parseDouble(l[2]),
              Double.parseDouble(l[3]),
              Double.parseDouble(l[4]),
              Double.parseDouble(l[5]),
              Long.parseLong(l[6])
            );
        }
      }
    }
  }

  //Date,Open,High,Low,Close,Adj Close,Volume
  /* This method is used to find Net return percentage between the first and last record.
       The return should be based on the closing price */
  public double findNetReturn() throws StockRecordNotFoundException {
    if (stockRecordList.length == 0 || stockRecordList == null) {
      throw new StockRecordNotFoundException();
    }
    return (
      (
        (
          stockRecordList[stockRecordList.length - 1].getDayClosingPrice() -
          stockRecordList[0].getDayClosingPrice()
        ) /
        stockRecordList[0].getDayClosingPrice()
      ) *
      100
    );
  }

  /* This method is used to find the closing stock price on a given date.
   * Appropriate exceptions should be thrown*/
  public double findClosingStockPrice(String date)
    throws StockRecordNotFoundException, InvalidDateException {
    Date d1;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      formatter.setLenient(false);
      d1 = formatter.parse(date);
    } catch (ParseException e) {
      throw new InvalidDateException();
    }
    if (stockRecordList == null || stockRecordList.length == 0) {
      throw new StockRecordNotFoundException();
    }
    boolean flag = false;
    for (int i = 0; i < stockRecordList.length; i++) {
      if (stockRecordList[i].getDate().compareTo(d1) == 0) {
        flag = true;
        return stockRecordList[i].getDayClosingPrice();
      }
    }
    if (!flag) {
      throw new StockRecordNotFoundException();
    }
    return -1;
  }

  /* This method is used to find Net return percentage between the two dates.
       The return should be based on the closing price */
  public double findNetReturn(String fromDate, String toDate)
    throws StockRecordNotFoundException, InvalidDateException {
    Date d1, d2;
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      formatter.setLenient(false);
      d1 = formatter.parse(fromDate);
      d2 = formatter.parse(toDate);
    } catch (ParseException e) {
      throw new InvalidDateException();
    }
    double fd1 = 0.0, fd2 = 0.0;
    boolean f1 = false, f2 = false;
    if (stockRecordList == null || stockRecordList.length == 0) {
      throw new StockRecordNotFoundException();
    }
    for (int i = 0; i < stockRecordList.length; i++) {
      if (stockRecordList[i].getDate().compareTo(d1) == 0) {
        fd1 = stockRecordList[i].getDayClosingPrice();
        f1 = true;
      }
      if (stockRecordList[i].getDate().compareTo(d2) == 0) {
        fd2 = stockRecordList[i].getDayClosingPrice();
        f2 = true;
      }
    }
    if (!f1 || !f2) {
      throw new StockRecordNotFoundException();
    }
    return ((fd2 - fd1) / fd1) * 100;
  }

  /**
   * this method is responsible for calculating the current investment value on a given evaluation date by specifying the
   * investment date and invested amount.
   * Hint: If an investor purchases x amount of stocks by investing an amount on a given date, What would be his value of his investment
   * If he sells it on an evaluation date. (Consider closing prices of stocks and assume investor can buy fractional number of stocks also)
   */
  public double findInvestmentValue(
    double investmentAmount,
    String investmentDate,
    String evaluationDate
  )
    throws InvalidDateException, StockRecordNotFoundException {
    double investmentClosingStockPrice = 0.0, evaluationClosingStockPrice = 0.0;
    investmentClosingStockPrice = findClosingStockPrice(investmentDate);
    evaluationClosingStockPrice = findClosingStockPrice(evaluationDate);

    if (
      investmentClosingStockPrice == 0.0 || evaluationClosingStockPrice == 0.0
    ) {
      throw new StockRecordNotFoundException();
    }
    double currentValue =
      (investmentAmount / investmentClosingStockPrice) *
      evaluationClosingStockPrice;

    return currentValue;
  }

  /* this is used to find the lowest closing price for the stock */
  // wrong comment - should return highest closing stock price as suggested by method name
  public double findHighestClosingStockPrice() {
    double highestClosingStockPrice = 0.0;
    for (int i = 0; i < stockRecordList.length; i++) {
      highestClosingStockPrice =
        Math.max(
          stockRecordList[i].getDayClosingPrice(),
          highestClosingStockPrice
        );
    }
    return highestClosingStockPrice;
  }

  /* this method takes an Array of Stock Records as input and returns that Array with records sorted in ascending order by date */
  public StockRecord[] sortByDate(StockRecord[] stockRecords) {
    if (stockRecords.length > 0) {
      Arrays.sort(
        stockRecords,
        (StockRecord obj1, StockRecord obj2) -> {
          if (obj1.getDate().compareTo(obj2.getDate()) <= 0) {
            return -1;
          }
          return 1;
        }
      );
    }
    return stockRecords;
  }

  /* this is used to find the daily avg return of the stock
    *  hint:
    *  If we have to find the daily return between 2020-03-01(d1)
    * and 2020-03-02(d2), the formula is:
	      daily return = (d2-d1)/d1*/
  public double findAvgDailyReturn() {
    double avgReturn = 0.0;
    for (int i = 1; i < stockRecordList.length; i++) {
      avgReturn +=
        (
          stockRecordList[i].getDayClosingPrice() -
          stockRecordList[i - 1].getDayClosingPrice()
        ) /
        stockRecordList[i - 1].getDayClosingPrice();
    }
    avgReturn /= (stockRecordList.length - 1);
    System.out.println(avgReturn);
    return avgReturn;
  }
}
