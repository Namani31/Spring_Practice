package com.example.myblog.dto;

import com.example.myblog.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;
    private String content;
    private String author;

    public Article toEntity() {
        return new Article(null, title, content, author);
        // Article Entity 객체 반환
    }
}