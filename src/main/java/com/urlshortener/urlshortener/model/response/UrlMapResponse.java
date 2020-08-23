package com.urlshortener.urlshortener.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.urlshortener.urlshortener.model.BaseError;
import lombok.Data;

@Data
public class UrlMapResponse {

  @JsonProperty(value = "redirect_target")
  private String redirectTarget;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private BaseError error;
}
