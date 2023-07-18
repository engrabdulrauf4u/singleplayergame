package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.service.GamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    GamingService gamingService;


    @GetMapping("/api/v1/games")     // End point for users to all available games .secured.
    public ResponseEntity getAllGames(){
        ResponseEntity games = gamingService.getAllGames();
        return games;
    }

    @PostMapping("/api/v1/games/{id}")      //Not Cleared
    public Long joinForGame(@PathVariable Long id){
        Long gameId = gamingService.joinForGame(id);
        return gameId;
    }

    @PostMapping("/api/v1/admin/games")  // Creates a game
    public ResponseEntity<Games> createGame(@RequestBody Games game){
        ResponseEntity gameUpdated = gamingService.createGame(game);
        return gameUpdated;
    }

    @PutMapping("/api/v1/admin/games/{id}")  //Only Admin can Update
    public ResponseEntity<Games> updateGame(@RequestBody Games game, @PathVariable(value = "id") Long gameId){
        ResponseEntity gameReturned = gamingService.updateGame(game,gameId);
        return  gameReturned ;
    }

    @DeleteMapping("/api/v1/admin/games/{id}")  //Only Admin can Update
    public ResponseEntity deleteGame(@PathVariable Long id){
        ResponseEntity response =  gamingService.deleteGame(id);

         return response;
    }



}
