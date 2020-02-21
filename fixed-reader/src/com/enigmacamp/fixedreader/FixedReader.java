package com.enigmacamp.fixedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FixedReader {
  private int[] rules = {2, 16, 46, 60, 115, 130};
  private String[] labels = {"ID", "Username", "Email", "Phone", "Address", "Job"};
  private File file;
  private BufferedReader reader;

  public FixedReader(String filePath) {
    this.file = new File(filePath);
  }

  public void read() throws FileNotFoundException, IOException {
    this.reader = new BufferedReader( new FileReader(file) );
    String line = "";

    while( (line = this.reader.readLine()) != null) {
      this.parseAndPrint(line);
    }
  }

  private void parseAndPrint(String text) {
    int start = 0;
    int end = 0;

    System.out.println("========================================================");
    System.out.println("                        Data User");
    System.out.println("========================================================");

    for (int n = 0; n < this.rules.length; n++) {
      end = rules[n];

      String label = labels[n];
      String data = text.substring(start, end).trim();
      System.out.println(label + ": " + data);

      start = end;
    }

    System.out.println("========================================================");
    System.out.println("");
  }
}