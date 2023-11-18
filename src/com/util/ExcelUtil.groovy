#! /usr/bin/groovy
package com.util

@Grab(group='org.apache.poi', module='poi', version='4.1.0')   // "group":"org.apache.poi", "id":"poi", "version":"3.8"
@Grab(group='org.apache.poi', module='poi-ooxml', version='4.1.0') //"group":"org.apache.poi", "id":"poi-ooxml", "version":"3.8"
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.*
import org.apache.poi.hssf.usermodel.*
import org.apache.poi.xssf.usermodel.*


public class ExcelUtil {

def printExcel(excelFilePath){

  //.withCloseable avaialble to new groovy only, similar to Close-with-Resource in Java
  //new FileInputStream(excelFilePath).withCloseable { fs ->
  //    Workbook wb = new XSSFWorkbook(fs)
  //    Sheet sheet = wb.getSheetAt(0) //Get the first sheet OR wb.getSheet("SheetName");
  //    // Iterate through rows and columns
  //    for (Row row : sheet) {
  //      for (Cell cell : row) {
  //         echo "Cell Value: ${cell.toString()}"
  //      }
  //    }
  //  }



  new FileInputStream(excelFilePath).with { fs ->
    try {
        new XSSFWorkbook(fs).with { wb ->
            Sheet sheet = wb.getSheetAt(0) //Get the first sheet OR wb.getSheet("SheetName");
            for (Row row : sheet) { // Iterate through rows and columns
                for (Cell cell : row) {
                  //echo "Cell Value: ${cell.toString()}"
                  println cell.toString()
                }
            }
        }// finally { wb.close() }
    } finally {
      fs.close()
     }
  }
 
}



def greetz(String name) {
  println "HELLO " + name
}

  
                                  

}
   
 

