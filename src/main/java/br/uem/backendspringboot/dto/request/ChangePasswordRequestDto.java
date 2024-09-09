package br.uem.backendspringboot.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePasswordRequestDto {
    private String oldPassword;
    private String newPassword;
    private String confirNewPassword;
    private String email;
}
