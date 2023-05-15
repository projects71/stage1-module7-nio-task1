package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


public class FileReader {
    private final Logger myLogger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {
        try(BufferedReader ignored = new BufferedReader(new java.io.FileReader(file))) {
            myLogger.info("check");
        }catch (IOException e) {

            myLogger.info(e.getMessage());
                throw new MyOwnRuntimeException("My message");

        }
        return new Profile(file);
    }
}
