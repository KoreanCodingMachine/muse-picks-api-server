package com.kjh.musepicks.service;

import com.kjh.musepicks.dto.account.AccountRequestDto;
import com.kjh.musepicks.dto.account.AccountResponseDto;

import java.util.List;

public interface AccountService {
    void create(AccountRequestDto accountRequestDto); // 유저 생성
    void delete(Long id); // 유저 삭제
    void updateUser(Long id, String name); // 유저 정보 수정
    AccountResponseDto getById(Long id); // 유저 단건 조회
    List<AccountResponseDto> getAll(); // 모든 유저 정보 조회

}
