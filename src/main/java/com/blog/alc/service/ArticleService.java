package com.blog.alc.service;

import com.blog.alc.model.Article;
import com.blog.alc.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class ArticleService {
    private final ArticleRepository articleRepository;
    private List<Article> listArticle = new ArrayList<>();


    public ArticleService(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article getListArticleById(Long id)
    { for (Article a : listArticle) {
        if (a.getId() == id)
            return a;
        }
        return null;
    }


    public Article getArticleByID(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("article " +id+" not found")
                );
    }

    public void createANewArticale(Article article) {
        articleRepository.save(article);
    }

    public void modifyArticale(Article update) {
        getArticleByID(update.getId());
        articleRepository.save(update);
    }

    public void deleteArticale(Long id) {
        articleRepository.deleteById(id);
    }

    public List<Article> getArticleByAuthor(String auteur) {
        return articleRepository.findByAuteur(auteur);
    }


}
