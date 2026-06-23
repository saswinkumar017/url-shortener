package com.urlshortener.urlshortener.utilities;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ShortCodeGenerator {
    public String generate(){
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
