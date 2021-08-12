package com.intership.internshipmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Long id;
    private String email;
    private String name;
    private String webAddress;
    private String address;
    private Long cityId;
}

