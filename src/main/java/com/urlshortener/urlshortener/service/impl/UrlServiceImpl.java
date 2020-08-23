package com.urlshortener.urlshortener.service.impl;

import com.urlshortener.urlshortener.model.BaseError;
import com.urlshortener.urlshortener.model.dao.UrlMap;
import com.urlshortener.urlshortener.model.request.NewUrlRequest;
import com.urlshortener.urlshortener.model.response.UrlMapResponse;
import com.urlshortener.urlshortener.repository.UrlMapDao;
import com.urlshortener.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlServiceImpl implements UrlService {

  @Autowired
  private UrlMapDao urlMapDao;

  @Override
  public UrlMapResponse getUrlMap(String targetPath) {
    UrlMapResponse response = new UrlMapResponse();
    try {
      if (targetPath.isEmpty())
        return null;
      UrlMap map = urlMapDao.findByTargetPath(targetPath);

      response.setRedirectTarget(map.getTargetPath());
      return response;
    } catch (Exception e) {
      BaseError error = new BaseError();
      error.setErrorCode(1);
      error.setErrorMessage("Internal Server Error");
      error.setDebugMessage("error: " + e.getCause());

      response.setError(error);
      return response;
    }
  }

  @Override
  public UrlMapResponse createUrlMap(NewUrlRequest urlRequest) {
    UrlMapResponse response = new UrlMapResponse();

    try {
      UrlMap urlMap = new UrlMap();
      urlMap.setTargetPath(urlRequest.getTargetPath());
      urlMap.setSourceUrl(urlRequest.getSourceUrl());

      if (urlRequest.getTargetPath() == null || urlRequest.getTargetPath().isEmpty()){
        urlMap.setTargetPath(UUID.randomUUID().toString());
      }
      UrlMap result = urlMapDao.save(urlMap);
      response.setRedirectTarget(result.getTargetPath());

      return response;
    } catch (Exception e) {
      BaseError error = new BaseError();
      error.setErrorCode(1);
      error.setErrorMessage("Internal Server Error");
      error.setDebugMessage("error: " + e.getCause());

      response.setError(error);
      return response;
    }
  }
}
