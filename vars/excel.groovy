#!/usr/bin/env groovy

import com.util.ExcelUtil
import com.util.OutputDto


def read(OutputDto outputDto){
    def excelUtil = new ExcelUtil()
    excelUtil.parseCIQFile(outputDto)
    //Note last object is also return onject in groovy
}





