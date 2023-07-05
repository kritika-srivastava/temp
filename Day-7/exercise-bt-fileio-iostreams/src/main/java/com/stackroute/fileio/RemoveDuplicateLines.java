package com.stackroute.fileio;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateLines {

  //write logic to read data from input.txt and  write result to output.txt
  public void removeDuplicateLines() throws IOException {
    Set<String> set = new HashSet<>();
    Scanner sc = new Scanner(new FileReader("input.txt")).useDelimiter("\n");
    while (sc.hasNextLine()) {
      String str = sc.nextLine();
      set.add(str);
    }
    FileWriter writer = new FileWriter("output.txt");
    for (String i : set) {
      writer.write(i + "\n");
    }

    writer.close();
  }
}
