package com.company.project.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

  private Properties prop = null;
  private FileInputStream fi = null;
  private FileOutputStream fo = null;

  public void writePropertyFile(
      String key, String value, String propertyFilePath, String comments) {

    try {
      prop = new Properties();
      fo = new FileOutputStream(propertyFilePath);
      prop.setProperty(key, value);
      prop.store(fo, comments);
      fo.close();
    } catch (FileNotFoundException ex) { // file does not exist
      ex.printStackTrace();
    } catch (IOException ex) { // I/O error
      ex.printStackTrace();
    }
  }

  public String readDataFromPropertiesFile(String propertyName, String propertyFilePath) {

    try {
      prop = new Properties();
      fi = new FileInputStream(propertyFilePath);
      prop.load(fi);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return prop.getProperty(propertyName);
  }
}
