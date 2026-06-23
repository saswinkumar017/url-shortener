package com.urlshortener.urlshortener.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.urlshortener.urlshortener.model.Url;
import com.urlshortener.urlshortener.repository.UrlRepo;

import com.urlshortener.urlshortener.repository.UrlRepo;
import com.urlshortener.urlshortener.utilities.ShortCodeGenerator;

@Service
public class UrlService {

    @Autowired
    private UrlRepo urlRepo ;

    @Autowired
    private ShortCodeGenerator shortCode;

    public Url addUrl(String url) {
        
        String shortcode;
        //  System.out.println("SERVICE = " + url);
        do{
            shortcode=shortCode.generate();
        }while(urlRepo.existsByShortCode(shortcode));

        Url t_url=new Url();

        t_url.setOriginalUrl(url);
        t_url.setShortCode(shortcode);
        t_url.setCreatedAt(LocalDateTime.now());

       return urlRepo.save(t_url);
    }

    public List<Url> getAll() {
        return urlRepo.findAll();
    }

    public String clearAll() {
        urlRepo.deleteAll();
        return "all cleared";
    }

    public String getOriginalUrl(String shortCode) {
        Url url= urlRepo.findByShortCode(shortCode).orElseThrow();

        return url.getOriginalUrl();
    }


}
