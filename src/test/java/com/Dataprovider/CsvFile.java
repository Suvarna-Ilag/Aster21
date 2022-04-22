package com.Dataprovider;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;

public class CsvFile {

	public static void main(String[] args) {
	    CSVReader reader = null;
	    try {
	      //parsing a CSV file into CSVReader class constructor  
	      reader = new CSVReader(new FileReader("E:\\Java Programs\\data.csv"));
	      String[] str;
	      List list=reader.readAll();
	      Iterator<String[]> itr=list.iterator();
	      while(itr.hasNext()) {
	    	  str=itr.next();
	    	  System.out.println(Arrays.toString(str));
	      }
	     
	      //reads one line at a time  
	      /* while ((str = reader.readNext()) != null) {
	        for (String token: str) {
	          System.out.println(token);
	        }
	        System.out.println("\n");
	      }*/
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
}
