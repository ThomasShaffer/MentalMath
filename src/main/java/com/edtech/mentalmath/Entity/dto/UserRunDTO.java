package com.edtech.mentalmath.Entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRunDTO {
    public String username;
    public Boolean correct;
    public String category;
}
