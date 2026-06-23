package com.urlshortener.urlshortener.controller;

import org.springframework.web.bind.annotation.RestController;

import com.urlshortener.urlshortener.dto.UrlRequest;
import com.urlshortener.urlshortener.model.Url;
import com.urlshortener.urlshortener.service.UrlService;
import com.urlshortener.urlshortener.utilities.ShortCodeGenerator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin("https://url-shortener-n.netlify.app/")
public class UrlController {
    
    @Autowired
    UrlService urlService; 
    
    // @Autowired
    // ShortCodeGenerator sh;

    @PostMapping("add")
    public ResponseEntity<Url> addUrl(@RequestBody UrlRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.addUrl(req.getUrl()));
    }

    @GetMapping("/")
    public List<Url> getAll(){
        return urlService.getAll();
    }

    @DeleteMapping("/clearall")
    public ResponseEntity clearAll(){
        urlService.clearAll();
        return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/{shortCode}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortCode){
        return ResponseEntity.ok(urlService.getOriginalUrl(shortCode));
    }
    
}
