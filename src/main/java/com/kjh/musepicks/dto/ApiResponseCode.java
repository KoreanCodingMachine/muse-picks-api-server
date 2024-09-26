package com.kjh.musepicks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResponseCode {
    POST_CREATED_OK(20001, "게시글 생성 성공")
    ,POST_DELETED_OK(20002, "게시글 삭제 성공")
    ,POST_UPDATED_OK(20003, "게시글 수정 성공")
    ,POST_NOT_FOUND(40001,"게시글 조회 실패")
    ,COMMENT_CREATED_OK(20001, "댓글 생성 성공")
    ,COMMENT_DELETED_OK(20002, "댓글 삭제 성공")
    ,COMMENT_UPDATED_OK(20003, "댓글 수정 성공")
    ,COMMENT_NOT_FOUND(40001,"댓글 조회 실패")
    ,CATEGORY_CREATED_OK(20001, "카테고리 생성 성공")
    ,CATEGORY_DELETED_OK(20002, "카테고리 삭제 성공")
    ,CATEGORY_UPDATED_OK(20003, "카테고리 수정 성공")
    ,CATEGORY_NOT_FOUND(40001,"카테고리 조회 실패")
    ,ACCOUNT_CREATED_OK(20001, "계정 생성 성공")
    ,ACCOUNT_DELETED_OK(20002, "계정 삭제 성공")
    ,ACCOUNT_UPDATED_OK(20003, "계정 수정 성공")
    ,ACCOUNT_NOT_FOUND(40001,"계정 조회 실패")
    ,RESERVATION_CREATED_OK(20001, "예약 생성 성공")
    ,RESERVATION_DELETED_OK(20002, "예약 삭제 성공")
    ,RESERVATION_UPDATED_OK(20003, "예약 수정 성공")
    ,RESERVATION_NOT_FOUND(40001,"예약 조회 실패")
    ,POST_CATEGORY_CREATED_OK(20001, "게시글 카테고리 생성 성공")
    ,POST_CATEGORY_DELETED_OK(20002, "게시글 카테고리 삭제 성공")
    ,POST_CATEGORY_UPDATED_OK(20003, "게시글 카테고리 수정 성공")
    ,POST_CATEGORY_NOT_FOUND(40001,"게시글 카테고리 조회 실패")
    ;

    private Integer statusCode;
    private String message;
}
