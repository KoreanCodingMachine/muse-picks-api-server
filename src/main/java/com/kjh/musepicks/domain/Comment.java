package com.kjh.musepicks.domain;

import com.kjh.musepicks.domain.common.BaseTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    // comment - post
    // 다 대 1 관계 (여러개의 댓글 - 하나의 포스트)
    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post posts;

    // comment - account
    // 다 대 1 관계 (여러개의 댓글 - 하나의 계정)
    @ManyToOne
    @JoinColumn (name = "account_id")
    private Account account;
}
