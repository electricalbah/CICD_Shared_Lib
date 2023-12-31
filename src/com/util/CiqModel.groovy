#!/usr/bin/env groovy
package com.util
//Maven POM to Groovy Grab Conversion
//<!-- https://mvnrepository.com/artifact/net.sf.oval/oval -->
//<dependency>
//    <groupId>net.sf.oval</groupId>
//    <artifactId>oval</artifactId>
//    <version>1.31</version>
//</dependency>
@Grab(group='net.sf.oval', module='oval', version='1.31')   

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.NotBlank;

import groovy.transform.ToString

//@ToString
class CiqModel {
  @NotNull
  @NotEmpty
  @NotBlank
  String paramater

  @NotNull
  @NotEmpty
  @NotBlank
  String value

  String description

  @NotNull
  @NotEmpty
  @NotBlank
  String systemTag
  
}
