package com.example.demo.article.service;

import com.example.demo.article.entity.Article;
import com.example.demo.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAll() {
        return this.articleRepository.findAll();
    }

    public Optional<Article> findById(Long id) {
        return this.articleRepository.findById(id);
    }

//    public List<Article> findByName(String name) {
//        return this.articleRepository.findAllByUserName(name);
//    }
//
//    public User save(User user) {
//        return this.userRepository.save(user);
//    }
//
//    public void delete(User user) {
//        this.userRepository.delete(user);
//    }
}
