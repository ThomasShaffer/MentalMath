package com.edtech.mentalmath.Entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RunDTO {
    private long userId;
    private int firstDigit;
    private int secondDigit;
    private boolean correct;
    private float timeElapsed;
}
