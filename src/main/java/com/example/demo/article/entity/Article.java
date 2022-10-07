package com.example.demo.article.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "article_code", length = 100,nullable = false, unique = true)
    private String articleCode;

    @Column(name = "article_name",length = 300,nullable = false)
    private String articleName;

    @Column(name = "article_description",length = 300,nullable = false)
    private String articleDescription;

    @Column(name = "article_stock",nullable = false)
    private Integer articleStock;



    @Column(name = "article_sale_price",nullable = false)
    private Double articleSalePrice;

    @Column(name = "article_purchase_price",nullable = false)
    private Double articlePurchasePrice;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
