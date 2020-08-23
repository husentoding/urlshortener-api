package com.urlshortener.urlshortener.model.request;

import lombok.Data;

@Data
public class NewUrlRequest {

  private String targetPath;
  private String sourceUrl;

}
