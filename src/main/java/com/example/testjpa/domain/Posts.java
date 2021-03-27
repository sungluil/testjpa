package com.example.testjpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @NoArgsConstructor
@EqualsAndHashCode(of = "id") @Builder
@AllArgsConstructor
public class Posts {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String author;

}
