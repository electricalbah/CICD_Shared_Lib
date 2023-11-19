#!/usr/bin/env groovy
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
//HSSFCell


class ExcelUtil {

int PARAM=0
int VALUE=1
int DESC=1
int S_TAG=1
int HEADER=0

def parseCIQFile(OutputDto outputDto){

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



  new FileInputStream(outputDto.ciqFilePath).with { fs ->
    try {
        new XSSFWorkbook(fs).with { wb ->
            Sheet sheet = wb.getSheetAt(0) //Get the first sheet OR wb.getSheet("SheetName");
            CiqModel ciqModel 
            for (Row row : sheet) { // Iterate through rows and columns
              if(row.getRowNum ()==HEADER)
                continue
              ciqModel = new CiqModel()
              ciqModel.setParamater(row.getCell(PARAM).getCellType().toString()) //getStringCellValue() //getNumericCellValue()  //getCellType()
              if (row.getCell(VALUE).getCellType() == "NUMERIC"){
                ciqModel.setValue(row.getCell(VALUE).getNumericCellValue())
              } else {
                ciqModel.setValue(row.getCell(VALUE).toString()()
              }
              ciqModel.setDescription(row.getCell(DESC).toString())
              ciqModel.setSystemTag(row.getCell(S_TAG).toString())
              outputDto.ciqItems.put(row.getCell(PARAM).toString(), ciqModel)
                //for (Cell cell : row) {
                  //echo "Cell Value: ${cell.toString()}"
                //  println cell.toString()
                //}
            }
        }// finally { wb.close() }
    } finally {
      fs.close()
     }
  }

  return outputDto
}



def greetz(String name) {
  return "HELLO " + name
}

  
                                  

}
   
 

