package com.kjh.musepicks.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String location;
    private Long price;
    private String start_dt;
    private Long views;
    private String playtime;
    private Long total_count;
    private Long reserved_count;
    private String description;

    // post - comment
    // 1 대 다 관계 (하나의 포스트 - 여러개의 댓글)
    @OneToMany (mappedBy = "posts")
    private List<Comment> comments;

    // post - account
    // 다 대 1 관계 (여러개의 포스트 - 한 명의 계정)
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    // post - reservation
    // 1 대 다 관계 (한 개의 포스트 - 여러 번의 예약)
    @OneToMany (mappedBy = "post")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany (mappedBy = "post")
    private List<PostCategory> postCategories = new ArrayList<>();
}
