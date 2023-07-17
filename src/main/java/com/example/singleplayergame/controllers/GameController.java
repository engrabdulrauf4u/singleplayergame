package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GamingService gamingService;


    @GetMapping("/api/v1/games")     // End point for users to all available games .secured.
    public List<Games> getAllGames(){
        List<Games> games = gamingService.getAllGames();
        return games;
    }

    @PostMapping("/api/v1/games/{id}")      //Not Cleared
    public Long joinForGame(@PathVariable Long id){
        Long gameId = gamingService.joinForGame(id);
        return gameId;
    }

    @PostMapping("/api/v1/admin/games")  // Creates a game
    public ResponseEntity<Games> createGame(@RequestBody Games game){
        Games gameUpdated = gamingService.createGame(game);
        return new ResponseEntity<>(gameUpdated, HttpStatus.OK);
    }

    @PutMapping("/api/v1/admin/games/{id}")  //Only Admin can Update
    public ResponseEntity<Games> createGame(@RequestBody Games game, @PathVariable(value = "id") Long gameId){
        Games gameReturned = gamingService.updateGame(game,gameId);
        return new ResponseEntity<>(gameReturned, HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/admin/games/{id}")  //Only Admin can Update
    public void deleteGame(@PathVariable Long id){
         gamingService.deleteGame(id);
    }



}
