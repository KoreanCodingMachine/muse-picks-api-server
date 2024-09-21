package com.kjh.musepicks.dto.account;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AccountUpdateRequestDto {
    @NotBlank
    private String name;
}
