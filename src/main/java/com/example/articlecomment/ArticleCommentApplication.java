package com.example.articlecomment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ArticleCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleCommentApplication.class, args);
    }

}
