package com.example.testjpa.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Transactional
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsDTO postsDTO) {
        return postsRepository.save(toEntity(postsDTO)).getId();
    }

    private Posts toEntity(PostsDTO postsDTO) {
        return Posts.builder()
                .title(postsDTO.getTitle())
                .content(postsDTO.getContent())
                .author(postsDTO.getAuthor())
                .build();
    }

    public Long update(Long id, PostsDTO postsDTO) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id = " + id));

        posts.update(postsDTO);

        return id;
    }

    public PostsDTO findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsDTO(entity);
    }
}
