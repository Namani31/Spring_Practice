package com.example.myblog.dto;

import com.example.myblog.entity.Article;

public class ArticleForm {
    private String title;
    private String content;
    private String author;

    public ArticleForm(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content, author);
        // Article Entity 객체 반환
    }

}