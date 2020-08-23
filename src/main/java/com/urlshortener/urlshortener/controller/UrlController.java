package com.urlshortener.urlshortener.controller;

import com.urlshortener.urlshortener.model.dao.UrlMap;
import com.urlshortener.urlshortener.model.request.NewUrlRequest;
import com.urlshortener.urlshortener.model.response.UrlMapResponse;
import com.urlshortener.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/url")
public class UrlController {

  @Autowired
  private UrlService urlService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UrlMapResponse> getUrlMap(HttpServletRequest request,
                                                  @RequestParam(value = "source", required = true) String sourceUrl) {
    UrlMapResponse response = urlService.getUrlMap(sourceUrl);

    if (response.getError() == null) {
      if (response.getRedirectTarget() == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
      }
      return ResponseEntity.ok(response);
    }

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

//  curl --location --request POST 'http://localhost:8080/url/' \
//          --header 'Content-Type: application/json' \
//          --data-raw '{
//          "sourceUrl": "instagram.com"
//  }'
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UrlMapResponse> createUrlMap(HttpServletRequest request,
                                                     @RequestBody NewUrlRequest urlRequest) {
    UrlMapResponse response = urlService.createUrlMap(urlRequest);

    if (response.getError() == null) {
      if (response.getRedirectTarget() == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
      }
      return ResponseEntity.ok(response);
    }

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

  }

}
