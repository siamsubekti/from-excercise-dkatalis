package com.enigmacamp.fixedreader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    FixedReader reader = new FixedReader("files/tugas-file.txt");

    try {
      reader.read();
    } catch (FileNotFoundException ffe) {
      ffe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
