#!/usr/bin/env groovy
package com.util

@Grab(group='org.apache.poi', module='poi', version='4.1.0')   // "group":"org.apache.poi", "id":"poi", "version":"3.8"
@Grab(group='org.apache.poi', module='poi-ooxml', version='4.1.0') //"group":"org.apache.poi", "id":"poi-ooxml", "version":"3.8"
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//HSSFCell
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.*
import org.apache.poi.hssf.usermodel.*
import org.apache.poi.xssf.usermodel.*
import org.apache.poi.ss.usermodel.*

import net.sf.oval.ConstraintViolation
import net.sf.oval.Validator



class ExcelUtil {

int PARAM=0
int VALUE=1
int DESC=1
int S_TAG=1
int HEADER=0

def parseCIQFile(OutputDto outputDto){
  
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
              if (row.getCell(VALUE).getCellType() == CellType.NUMERIC){
                ciqModel.setValue(row.getCell(VALUE).getNumericCellValue().intValue().toString()) //for some reason POI will convert digits in the excel to double
              } else {
                ciqModel.setValue(row.getCell(VALUE).toString())
              }
              ciqModel.setDescription(row.getCell(DESC).toString())
              ciqModel.setSystemTag(row.getCell(S_TAG).toString())
              
              //validate CIQ data
              validateCIQRow(ciqModel, outputDto) 
              
              //set output DTO
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

 def validateCIQRow(CiqModel ciqModel, OutputDto outputDto) {
  // def excelCiqModel = new CiqModel("a", "b", "c", "d")              
  Validator validator = new Validator();
  List<ConstraintViolation> violations = validator.validate(ciqModel);
  if(!violations.isEmpty()) {
    print ">>>>> FAILURE"
    outputDto.errors.add(violations.toString())
    print violations.size()
    print violations
    //throw new Exception(violations);
    print "BBBBBB"
    } else {
        print ">>>>> SUCCESS"
        println ciqModel                    
      } 
 }

//TODO - need clean up
//https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/CellType.html
 def getValue(Row row, Cell cell, List data) {
    def rowIndex = row.getRowNum()
    def colIndex = cell.getColumnIndex()
    def value = ""
    switch (cell.getCellType()) {
      case CellType.STRING:
        value = cell.getRichStringCellValue().getString();
        break;
      case CellType.NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
            value = cell.getDateCellValue();
        } else {
            value = cell.getNumericCellValue();
        }
        break;
      case CellType.BOOLEAN:
        value = cell.getBooleanCellValue();
        break;
      case CellType.FORMULA:
        value = cell.getCellFormula();
        break;
      default:
        value = ""
    }
    data[colIndex] = value
    data
  }



def greetz(String name) {
  return "HELLO " + name
}

  
                                  

}
   
 

