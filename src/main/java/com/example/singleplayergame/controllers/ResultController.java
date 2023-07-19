package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Results;
import com.example.singleplayergame.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ResultController {


    @Autowired
    ResultService resultService;

    @PostMapping("/games/{gameId}/results")        //secured players can view their own games.
    public ResponseEntity createGameResult(@RequestBody Results result, @PathVariable Long gameId){
        ResponseEntity results = resultService.createGameResult(result,gameId);
        return results;
    }

    @GetMapping("/games/{gameId}/results")        //secured players can view their own games.
    public ResponseEntity getGameResults(@PathVariable Long gameId) throws Exception {
        Results results = resultService.getGameResult(gameId);

        try{
            Long id = results.getResultId();
        }catch(Exception Ex){
            return   new ResponseEntity<>("Data not Found against gameId "+gameId, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(results,HttpStatus.OK);
    }

    @GetMapping("/admin/games/{gameId}/results")    //secured Only Admin can access this.
    public ResponseEntity getAllGameResults(@PathVariable Long gameId){
        ResponseEntity results = resultService.getAllGameResults(gameId);
        return results;
    }

}
