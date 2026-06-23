package com.urlshortener.urlshortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlshortener.urlshortener.model.Url;

@Repository
public interface UrlRepo extends JpaRepository<Url,Integer> {
    boolean existsByShortCode(String shortcode);
    Optional<Url> findByShortCode(String shortCode);
}
