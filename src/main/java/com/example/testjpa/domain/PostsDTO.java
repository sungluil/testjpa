package com.example.testjpa.domain;

import lombok.*;


@NoArgsConstructor
@Builder @Setter @Getter
public class PostsDTO {
    private String title;
    private String content;
    private String author;

}
