package com.example.testjpa.domain;

import lombok.*;


@NoArgsConstructor
@Builder @Setter @Getter
@AllArgsConstructor
public class PostsDTO {
    private String title;
    private String content;
    private String author;

    @Override
    public String toString() {
        return "PostsDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public PostsDTO(Posts posts) {
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getContent();
    }
}
