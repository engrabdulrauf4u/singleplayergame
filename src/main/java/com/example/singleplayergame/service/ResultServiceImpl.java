package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.model.Results;
import com.example.singleplayergame.repository.GamesRepository;
import com.example.singleplayergame.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ResultServiceImpl implements ResultService{

    @Autowired
    ResultsRepository resultRepository;

    @Autowired
    GamesRepository gamesRepository;

    @Override
    public Results getGameResult(Long gameId) throws Exception {

        Results results = resultRepository.getReferenceById(gameId);

        return   results;
    }
    @Override
    public ResponseEntity getAllGameResults(Long gameId) {
        return (ResponseEntity) resultRepository.findAll();
    }

    @Override
    public ResponseEntity createGameResult(Results result, Long gameId) {


        Games game= null;
        try{
            game = gamesRepository.findById(gameId).get();
        }catch (Exception exception){
            return new ResponseEntity("Game Data not found against Id "+gameId,HttpStatus.BAD_REQUEST);
        }

        Results resultSaved =null;

        if(result.getResultId()!=null)
        {
            return new ResponseEntity("Please don't provide resultId to create Result ",HttpStatus.BAD_REQUEST);

        }
        {
            try{
                Results resultsNew  =new  Results();

                resultsNew.setGameResult(result.getGameResult());
                resultsNew.setGames(game);
                resultsNew.setScore(result.getScore());

                resultSaved = resultRepository.save(resultsNew);
            }catch(Exception exception){
                return new ResponseEntity(" "+exception.getMessage(),HttpStatus.BAD_REQUEST);

            }

        }

        return new ResponseEntity(resultSaved,HttpStatus.OK);

    }
}
