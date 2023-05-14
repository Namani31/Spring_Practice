package com.example.myblog.controller;

import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j // 로깅 (logging) 기능 추가, Lombok 플러그인 설치 필요
@Controller // 컨트롤러 선언, 요청과 응답 처리
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 리파지토리 객체를 가져옴 (DI)
    private ArticleRepository articleRepository;

    @GetMapping("/articles") // 해당 요청을 처리하도록, 메소드를 등록
    public String index(Model model) {  // 모델 객체를 가져옴
       /*
            데이터를 모델에 등록, 등록된 데이터는 뷰 페이지에서 사용 가능
            key (변수명): "msg",
            value (내용): "안녕하세요, 반갑습니다!"
        */
        model.addAttribute("msg", "안녕하세요, 반갑습니다!");
        return "articles/index"; // 뷰 페이지 설정
    }
    
    @GetMapping("/articles/new") // GET 요청이 해당 url로 오면, 아래 메소드를 수행
    public String newArticle() {
        return "articles/new"; // 보여줄 뷰 페이지
    }

    @PostMapping("/articles") // Post 방식으로 "/articles" 요청이 들어오면, 아래 메소드 수행!
    public String create(ArticleForm form) { // 폼 태그의 데이터가 ArticleForm 객체로 만들어 짐!
        return "redirect:/articles"; // 브라우저를 "/articles" url로 보냄!
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        // System.out.println(form.toString()); -> 로깅 기능으로 대체

        // 1. Dto를 Entity 변환
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository에게 Entity를 DB로 저장하게 함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "";
    }
}
