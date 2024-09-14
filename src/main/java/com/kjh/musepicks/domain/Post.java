package com.kjh.musepicks.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String location;
    private long price;
    private String start_dt;
    private long views;
    private long playtime;
    private long total_count;
    private long reserved_count;
    private String description;

    // post - comment
    // 1 대 다 관계 (하나의 포스트 - 여러개의 댓글)
    @OneToMany (mappedBy = "post")
    private List<Comment> comments;


    // post - account
    // 다 대 1 관계 (여러개의 포스트 - 한 명의 계정)
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Account account;


    // post - reservation
    // 1 대 다 관계 (한 개의 포스트 - 여러 번의 예약)
    @OneToMany (mappedBy = "post")
    private List<Reservation> reservations;

}
