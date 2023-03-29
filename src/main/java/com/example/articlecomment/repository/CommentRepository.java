package com.example.articlecomment.repository;

import com.example.articlecomment.article.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<ArticleComment, Long> {
    List<ArticleComment> findAllByOrderByModifiedAtDesc();
}
