package ua.hillel.javapro.challenger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.hillel.javapro.challenger.services.ChallengerService;
import ua.hillel.javapro.challenger.services.TaskDifficulty;

@RestController
public class ChallengerController {

    @Autowired
    private ChallengerService challengerService;

    @GetMapping("/challenger")
    public String challenge(@RequestParam(required = false, name = "task", defaultValue = "arrays") String task,
                            @RequestParam(required = false, name = "difficulty", defaultValue = "EASY") String difficulty
    ) {
        TaskDifficulty taskDifficulty = TaskDifficulty.valueOf(difficulty.toUpperCase());
        return challengerService.getChallenge(task, taskDifficulty);
    }
}
