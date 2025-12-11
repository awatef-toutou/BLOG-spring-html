package com.blog.alc.controller;

import com.blog.alc.model.Article;
import com.blog.alc.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("listArticle", articleService.getArticles());
        return "index";
    }

    @GetMapping("/nouveau")
    public String getForm(Model model)
    {  //on ceer un objet vide pour que cet objet reçoie les données du formulaire
        model.addAttribute("article", new Article());
        return "form";
    }

    @GetMapping("/detail/{id}")
    public  String getDetail(Model model, @PathVariable Long id)
    {
        model.addAttribute("article",articleService.getArticleByID(id));
        return "detail";
    }

   @PostMapping("/nouveau")
    public String addArcticle(@ModelAttribute Article article, Model model)
    {
    articleService.createANewArticale(article);
     return "redirect:/";
    }

    @GetMapping("/{author}")
    public String getArticleByAuthor(@PathVariable String author,Model model) {
        model.addAttribute("listArticle",articleService.getArticleByAuthor(author));
        return "auteur";
    }


}
