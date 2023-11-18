#!/usr/bin/env groovy

import com.util.ExcelUtil


def read(excelFilePath){
    def excel = new ExcelUtil()
    excel.printExcel(excelFilePath)

    //return 
    
    //print "SUCCESS " + excelFilePath
}



def greet(url){
    def excel = new ExcelUtil()
    excel.greetz(url)
    //return "HELLO " + url
}




