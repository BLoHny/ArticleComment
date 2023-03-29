package com.example.articlecomment.service;


import com.example.articlecomment.article.ArticleComment;
import com.example.articlecomment.dto.ArticleRequestDto;
import com.example.articlecomment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 꼭 필요한 요소(final) 자동 생성
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, ArticleRequestDto requestDto) {

        ArticleComment articleComment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        articleComment.update(requestDto);
        return articleComment.getId();
    }
}
