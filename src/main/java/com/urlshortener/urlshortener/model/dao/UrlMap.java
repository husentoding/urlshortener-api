package com.urlshortener.urlshortener.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "url_map")
public class UrlMap {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;

  @Column(name = "sourceUrl")
  private String sourceUrl;

  @Column(name = "targetPath")
  private String targetPath;
}
