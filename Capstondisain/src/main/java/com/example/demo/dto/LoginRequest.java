package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "이메일이 비어있습니다.")
    @Size(min = 1, max = 50, message = "이메일은 1 ~ 50자 이여야 합니다!")
    @Email
    private String MemberEmail;
    @NotBlank(message = "비밀번호가 비어있습니다.")
    @Size(min = 1, max = 30, message = "비밀번호는 1 ~ 30자 이여야 합니다!")
    private String MemberPassword;
}
