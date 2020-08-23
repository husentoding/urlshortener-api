package com.urlshortener.urlshortener.service;

import com.urlshortener.urlshortener.model.request.NewUrlRequest;
import com.urlshortener.urlshortener.model.response.UrlMapResponse;

public interface UrlService {

  UrlMapResponse getUrlMap(String targetPath);

  UrlMapResponse createUrlMap(NewUrlRequest urlRequest);

}
