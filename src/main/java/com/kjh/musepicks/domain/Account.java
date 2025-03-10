package com.kjh.musepicks.domain;

import com.kjh.musepicks.domain.common.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Account extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nickname;
    private String name;
    private String phone_number;
    private String email;
    private String birthdate;
    private String password;
    private String joined_dt;
    private String gender;

    // account - post
    // 1 대 다 관계 (하나의 계정 - 여러개의 포스트)
    @OneToMany (mappedBy = "account")
    private List<Post> posts;


    // account - reservation
    // 1 대 다 관계 (하나의 계정 - 여러개의 예약)
    @OneToMany (mappedBy = "account")
    private List<Reservation> reservations;


    // account - comment
    // 1 대 다 관계 (하나의 계정 - 여러개의 댓글)
    @OneToMany (mappedBy = "account")
    private List<Comment> comments;
}
