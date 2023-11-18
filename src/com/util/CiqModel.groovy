import groovy.transform.ToString

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

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
