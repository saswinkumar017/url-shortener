package com.urlshortener.urlshortener.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "urls")
@Entity
@Data
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "original_url",length = 2048)
    private String originalUrl;
    
    @Column(name = "short_code")
    private String shortCode;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
