package com.edtech.mentalmath.Entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class LeaderboardDTO {
    List<StreakDTO> streaks;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StreakDTO {
        public String username;
        public String streak;
        public String category;

    }
}
