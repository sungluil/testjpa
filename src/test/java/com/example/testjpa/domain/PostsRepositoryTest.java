package com.example.testjpa.domain;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class PostsRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    private final PostsRepository postsRepository;

    @DisplayName("저장 테스트")
    @Test
    public void 저장테스트() throws Exception {
        String title = "제목";
        String content = "내용";

        Posts posts = Posts.builder()
                .title(title)
                .content(content)
                .author("josungluil@naver.com")
                .build();
        postsRepository.save(posts);

        List<Posts> postsList = postsRepository.findAll();

        Posts posts1 = postsList.get(0);
        assertThat(posts1.getTitle()).isEqualTo(title);
        assertThat(posts1.getContent()).isEqualTo(content);
    }
}