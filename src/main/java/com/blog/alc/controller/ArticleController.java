package com.blog.alc.controller;

import com.blog.alc.model.Article;
import com.blog.alc.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    private ArticleService articleService;
    private Article article;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("listArticle", articleService.getArticles());
        return "index";
    }

    @GetMapping("/nouveau")
    public String getForm()
    {
        return "form";
    }

    @GetMapping("/detail/{id}")
    public  String getDetail(Model model, @PathVariable Long id)
    {
        model.addAttribute("article",articleService.getListArticleById(id));
        return "detail";
    }

 @PostMapping("/nouveau")
    public String addArcticle(@ModelAttribute Model model, Article article)
 {
    articleService.createANewArticle(article);
     return "redirect:/";
 }


}
