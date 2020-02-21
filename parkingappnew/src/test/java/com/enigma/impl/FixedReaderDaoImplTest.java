package com.enigma.impl;

import com.enigma.dao.FixedReaderDao;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FixedReaderDaoImplTest {

    //read_shouldReturn_anOutput_basedOn_fileInput
    @Test
    public void read_should_return_an_output_based_on_file_input() throws IOException {
        BufferedReader bufferedReaderInput = Files.newBufferedReader(Paths.get("E:\\Java\\fromExcerciseDkatalis\\file-text.txt"));
        FixedReaderDao fixedReaderDao = new FixedReaderDaoImpl();
        BufferedReader bufferedReaderOutput = Files.newBufferedReader(Paths.get("E:\\Java\\fromExcerciseDkatalis\\file-output.txt"));
        FixedReaderDao fixedReaderDao1 = new FixedReaderDaoImpl();
        String expectedStringResult = fixedReaderDao.read(bufferedReaderInput);
        String actualStringResult = fixedReaderDao1.read(bufferedReaderOutput);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

//    @Test
//    public void read_should_return_error_FileNotException_when_file_input_text_not_found() throws IOException {
//        BufferedReader bufferedReaderInput = Files.newBufferedReader(Paths.get("E:\\Java\\fromExcerciseDkatalis\\file-text.txt"));
//        FixedReaderDao fixedReaderDao = new FixedReaderDaoImpl();
//        BufferedReader bufferedReaderOutput = Files.newBufferedReader(Paths.get("E:\\Java\\fromExcerciseDkatalis\\file-text.txt"));
//        FixedReaderDao fixedReaderDao1 = new FixedReaderDaoImpl();
//        String expectedStringResult = fixedReaderDao.read()
//        String actualStringResult = fixedReaderDao1.read(bufferedReaderOutput);
//        Assert.assertEquals(expectedStringResult, actualStringResult);
//    }
}