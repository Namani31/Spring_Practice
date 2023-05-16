package com.example.myblog.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Getter // 게터를 자동 생성
@NoArgsConstructor // 디폴트 생성자 추가
// @AllArgsConstructor // id, title, content, author를 파라미터로 하는 생성자를 자동으로 만들어줌
@ToString   // toString() 자동 생성
@Entity // DB가 해당 객체를 인식 가능!
public class Article {

    @Id // 대표값을 지정! like a 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 관리, 매 생성시, 1, 2, ... 증가
    private Long id;

    @Column(length = 100, nullable = false) // 최대 100글자, 비어 있으면 안 됨, 추후 SQL 학습
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)    // 텍스트 타입, 비어있으면 안 됨, 추후 SQL 학습
    private String content;

    @Column(length = 100, nullable = false) //
    private String author;

    @Builder // 빌더 패턴 적용!
    public Article(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        // return new Article(null, title, content, author);
    }
}
