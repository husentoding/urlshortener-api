package com.urlshortener.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class BaseError {

  private Integer errorCode;
  private String errorMessage;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String debugMessage;

}
