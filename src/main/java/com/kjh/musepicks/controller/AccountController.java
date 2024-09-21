package com.kjh.musepicks.controller;

import com.kjh.musepicks.dto.ApiResponse;
import com.kjh.musepicks.dto.ApiResponseCode;
import com.kjh.musepicks.dto.account.AccountRequestDto;
import com.kjh.musepicks.dto.account.AccountResponseDto;
import com.kjh.musepicks.dto.account.AccountUpdateRequestDto;
import com.kjh.musepicks.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Operation(summary = "계정 생성", description = "새로운 유저를 생성한다.")
    @PostMapping("/api/accounts")
    public ApiResponse postAccount(@RequestBody @Valid AccountRequestDto accountRequestDto) {

        accountService.create(accountRequestDto);

        return ApiResponse.of(ApiResponseCode.ACCOUNT_CREATED_OK);
    }

    @Operation(summary = "계정 삭제", description = "유저 정보 단건을 삭제한다.")
    @DeleteMapping("/api/accounts/{id}")
    public ApiResponse deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ApiResponse.of(ApiResponseCode.ACCOUNT_DELETED_OK);
    }

    @Operation(summary = "모든 유저 조회", description = "모든 유저를 조회한다.")
    @GetMapping("/api/accounts")
    public List<AccountResponseDto> getAllAccount() {
        return accountService.getAll();
    }

    @Operation(summary = "유저 단건 조회", description = "유저 아이디를 받아 단건 조회한다.")
    @GetMapping("/api/accounts/{id}")
    public AccountResponseDto getAccountById(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @Operation(summary = "멤버 수정", description = "유저 id를 받아서 수정한다.")
    @PutMapping("/api/accounts/{id}")
    public ApiResponse updateAccount(@RequestBody @Valid AccountUpdateRequestDto accountUpdateRequestDto, @PathVariable Long id) {
        accountService.updateUser(id, accountUpdateRequestDto.getName());
        return ApiResponse.of(ApiResponseCode.ACCOUNT_UPDATED_OK);
    }
}
