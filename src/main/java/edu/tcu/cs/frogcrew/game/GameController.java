package edu.tcu.cs.frogcrew.game;

import edu.tcu.cs.frogcrew.system.Result;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.endpoint.base-url}/gameSchedule")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public Result findAllGames() {
        return null;
    }

    @GetMapping("/game/{gameId}")
    public Result findGameById(@PathVariable int gameId) {
        return null;
    }

    @PutMapping("/game/{gameId}")
    public Result updateGame(@PathVariable int gameId,@RequestBody Game game) {
        return null;
    }

    @GetMapping("/{scheduleId}/games")
    public Result findGamesByScheduleId(@PathVariable int scheduleId) {
        return null;
    }


}
