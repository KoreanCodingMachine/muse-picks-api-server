package com.kjh.musepicks.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // reservation - post
    // 다 대 1 관계 (여러개의 예약 - 한개의 포스트)
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    // reservation - account
    // 다 대 1 관계 (여러개의 예약 - 한명의 계정)
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
