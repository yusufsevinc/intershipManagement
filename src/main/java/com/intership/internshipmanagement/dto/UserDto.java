package com.intership.internshipmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;
    private String password;

    public UserDto(String email) {
        this.email = email;
    }

}
