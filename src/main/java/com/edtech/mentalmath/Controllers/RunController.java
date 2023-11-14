package com.edtech.mentalmath.Controllers;

import com.edtech.mentalmath.Entity.dto.LeaderboardDTO;
import com.edtech.mentalmath.Entity.dto.RunDTO;
import com.edtech.mentalmath.Service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class RunController {
    private RunService runService;

    @Autowired
    public RunController(RunService runService) {
        this.runService = runService;
    }

    @PostMapping("/play")
    public ResponseEntity postPlayPage(@RequestBody RunDTO runDTO) {
        boolean saved = runService.save(runDTO);
        if (saved) return ResponseEntity.accepted().body(new HashMap<>(){{ put("runs", "saved"); }});
        else return ResponseEntity.internalServerError().body(new HashMap<>(){{ put("run", "not saved"); }});
    }

    @GetMapping("/leaderboard")
    public ResponseEntity getLeaderboardPage() {
        LeaderboardDTO leaderboardDTO = runService.getLeaderboardData();
        return ResponseEntity.accepted().body(new HashMap<>(){{ put("data", leaderboardDTO.getStreaks()); }});
    }
}
