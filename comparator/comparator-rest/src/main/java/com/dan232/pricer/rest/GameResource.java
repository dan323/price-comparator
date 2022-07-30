package com.dan232.pricer.rest;

import com.dan232.pricer.comparator.GameQueryUseCase;
import com.dan232.pricer.comparator.model.GameBasic;
import com.dan232.pricer.comparator.model.GamePriced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameResource {

    private final GameQueryUseCase useCase;

    public GameResource(GameQueryUseCase useCase){
        this.useCase = useCase;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<GamePriced> getGameById(@PathVariable String gameId){
        var game = useCase.getGame(gameId).perform();
        if (game != null){
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/game")
    public ResponseEntity<List<GameBasic>> getAllGames(){
        var games = useCase.getGames().perform();
        if (games == null || games.size() == 0){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(games);
        }
    }

    @GetMapping("/game/category/{category}")
    public ResponseEntity<List<GameBasic>> getGamesByCategory(@PathVariable String category){
        var games = useCase.getGamesByCategory(category).perform();
        if (games == null || games.size() == 0){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(games);
        }
    }
}
