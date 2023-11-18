#!/usr/bin/env groovy

import com.util.ExcelUtil


def read(excelFilePath){
    //def excel = new ExcelUtil()
    //excel.printExcel(excelFilePath)

    return "SUCCESS " + excelFilePath
}



def greet(url){
    return "HELLO " + url
}




