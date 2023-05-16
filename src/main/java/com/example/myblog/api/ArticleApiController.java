package com.example.myblog.api;

import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ArticleApiController {

    @PostMapping("/api/articles")   // POST 요청이 "/api/articles" url 로 온다면, 메소드 수행
    public Long create(@RequestBody ArticleForm form) { // JSON 데이터를 받아옴
        log.info(form.toString());  // 받아온 데이터 확인
        return 0L;
    }
}
