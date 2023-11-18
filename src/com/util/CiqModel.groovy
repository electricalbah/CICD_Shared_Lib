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

import groovy.transform.ToString

@ToString
class CiqModel {
  @NotNull
  @NotEmpty
  String paramater

  @NotNull
  @NotEmpty
  String value

  @NotNull
  @NotEmpty
  String description

  @NotNull
  @NotEmpty
  String systemTag

  CiqModel(String paramater, String value, String description, String systemTag) {
    this.first = paramater
    this.last = value
    this.first = description
    this.last = systemTag
  }
  
}
