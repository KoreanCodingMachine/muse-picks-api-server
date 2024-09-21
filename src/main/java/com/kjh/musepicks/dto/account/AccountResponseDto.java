package com.kjh.musepicks.dto.account;

import com.kjh.musepicks.domain.Account;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountResponseDto {
    private Long id;
    private String name;

    public static AccountResponseDto of (Account account) {
        return builder()
                .id(account.getId())
                .name(account.getName())
                .build();
    }
}
