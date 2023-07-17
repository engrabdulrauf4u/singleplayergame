package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Results;
import com.example.singleplayergame.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {


    @Autowired
    ResultService resultService;

    @PostMapping("/api/v1/games/{gameId}/results")        //secured players can view their own games.
    public Results createGameResult(@RequestBody Results result, @PathVariable Long gameId){
        Results results = resultService.createGameResult(result,gameId);
        return results;
    }

    @GetMapping("/api/v1/games/{gameId}/results")        //secured players can view their own games.
    public Results getGameResults(@PathVariable Long gameId){
        Results results = resultService.getGameResult(gameId);
        return results;
    }

    @GetMapping("/api/v1/admin/games/{gameId}/results")    //secured Only Admin can access this.
    public List<Results> getAllGameResults(){
        List<Results> results = resultService.getAllGameResults();
        return results;
    }

}
