package com.example.articlecomment.controller;

import com.example.articlecomment.article.ArticleComment;
import com.example.articlecomment.dto.ArticleRequestDto;
import com.example.articlecomment.repository.CommentRepository;
import com.example.articlecomment.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/memos")
    public ArticleComment createComment(@RequestBody ArticleRequestDto requestDto) {
        ArticleComment articleComment = new ArticleComment(requestDto);
        return commentRepository.save(articleComment);
    }

    @GetMapping("/api/memos")
    public List<ArticleComment> getComments() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody ArticleRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
