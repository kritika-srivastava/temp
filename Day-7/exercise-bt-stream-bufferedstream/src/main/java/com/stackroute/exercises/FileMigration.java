package com.stackroute.exercises;

import java.io.*;

public class FileMigration {

  // Write here logic to read content of first file and write it in second file
  public String fileContentDuplicator(String firstFile, String secondFile)
    throws IOException {
    if (
      firstFile == null ||
      firstFile.isBlank() ||
      secondFile == null ||
      secondFile.isBlank()
    ) {
      return "Given fileName to read or write is empty, null or blank space";
    }
    // FileReader in = new FileReader(;
    BufferedReader br = new BufferedReader(new FileReader(firstFile.trim()));
    FileWriter writer = new FileWriter(secondFile.trim());

    String line, s = "";
    PrintWriter write = new PrintWriter(secondFile.trim());

    write.close();
    while ((line = br.readLine()) != null) {
      System.out.println(line);

      writer.write(line.trim());
      s += line.trim();
    }

    br.close();
    writer.close();

    return s;
  }
}
