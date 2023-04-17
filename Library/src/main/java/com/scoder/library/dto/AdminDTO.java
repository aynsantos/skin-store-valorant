package com.scoder.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdminDTO {

    @Size(min = 3, max = 30, message = "Nome inválido!(3-30 Caracteres")
    private String name;
    @Size(min = 3, max = 10, message = "Username inválido!(3-10 Caracteres")
    private String username;
    @Size(min = 5, max = 10, message = "Password inválido!(5-10 Caracteres")
    private String password;
    private String confirmPassword;
}
