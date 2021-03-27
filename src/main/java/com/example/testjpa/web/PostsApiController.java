package com.example.testjpa.web;

import com.example.testjpa.domain.PostsDTO;
import com.example.testjpa.domain.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsDTO postsDTO) {
        return postsService.save(postsDTO);
    }

}
