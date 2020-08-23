package com.urlshortener.urlshortener.repository;

import com.urlshortener.urlshortener.model.dao.UrlMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UrlMapDao extends JpaRepository<UrlMap, BigInteger> {

  UrlMap findByTargetPath(String targetPath);

}
