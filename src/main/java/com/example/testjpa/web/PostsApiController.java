package com.example.testjpa.web;

import com.example.testjpa.domain.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

}
