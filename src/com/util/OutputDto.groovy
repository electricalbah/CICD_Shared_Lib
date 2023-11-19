#!/usr/bin/env groovy
package com.util

class OutputDto {
  String ciqFilePath
  List<String> errors //both Business and system Errors
  Map<String,CiqModel> ciqItems


}
