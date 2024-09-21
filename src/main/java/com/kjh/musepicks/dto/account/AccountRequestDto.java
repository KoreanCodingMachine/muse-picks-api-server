package com.kjh.musepicks.dto.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountRequestDto {
    @Size(min = 2, max = 20)
    @NotBlank
    private String nickname;

    @Size(min = 2, max = 10)
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotBlank
    private String birth_date;

    @NotBlank
    private String password;

    @NotBlank
    private String phone_number;

    @NotBlank
    private String password_confirm;
}
