package com.edtech.mentalmath.Service;

import com.edtech.mentalmath.Entity.dto.LeaderboardDTO;
import com.edtech.mentalmath.Entity.dto.RunDTO;
import com.edtech.mentalmath.Entity.dto.UserRunDTO;
import com.edtech.mentalmath.Entity.model.Run;
import com.edtech.mentalmath.Repository.RunJPARepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Service
public class RunService {

    @Autowired
    private UserService userService;
    @Autowired
    private RunJPARepository runJPARepository;

    public RunService(UserService userService, RunJPARepository runJPARepository) {
        this.userService = userService;
        this.runJPARepository = runJPARepository;
    }

    public boolean save(RunDTO runDTO) {
        Run run = Run.builder()
                .userId(userService.findUserById(runDTO.getUserId()))
                .category(getCategory(runDTO.getFirstDigit(), runDTO.getSecondDigit()))
                .firstDigit(runDTO.getFirstDigit())
                .secondDigit(runDTO.getSecondDigit())
                .correct(runDTO.isCorrect())
                .timeElapsed(runDTO.getTimeElapsed())
                .build();
        runJPARepository.save(run);
        return true;
    }

    private String getCategory(int firstDigit, int secondDigit) {
        return String.valueOf(firstDigit).length() + "x" + String.valueOf(secondDigit).length();
    }

    public LeaderboardDTO getLeaderboardData() {
        List<UserRunDTO> data = runJPARepository.getLeaderboardData();

        List<LeaderboardDTO.StreakDTO> streakData = new ArrayList<>();

        List<LeaderboardDTO.StreakDTO> finalStreakData = streakData;
        data.stream()
                .collect(Collectors.groupingBy(UserRunDTO::getUsername, Collectors.groupingBy(UserRunDTO::getCategory)))
                .entrySet()
                .forEach(
                    userNameEntry -> {
                        String username = userNameEntry.getKey();
                        Map<String, List<UserRunDTO>> runs = userNameEntry.getValue();
                        System.out.println(username);
                        for (String category : runs.keySet()) {
                            int streak = 0;
                            List<UserRunDTO> runData = runs.get(category);
                            for (UserRunDTO dto : runData) {
                                if (dto.correct) streak++;
                                else streak = 0;
                            }
                            finalStreakData.add(new LeaderboardDTO.StreakDTO(username, String.valueOf(streak), category));
                        }
                    });

        streakData = streakData.stream()
                .filter(entry -> !entry.getStreak().equalsIgnoreCase("0"))
                .sorted(Comparator.comparing(streak -> -Integer.parseInt(streak.getStreak())))
                .collect(Collectors.toList());

        return new LeaderboardDTO(streakData);
    }


}
