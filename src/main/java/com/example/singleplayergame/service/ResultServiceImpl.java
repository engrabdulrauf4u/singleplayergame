package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.model.Results;
import com.example.singleplayergame.repository.GamesRepository;
import com.example.singleplayergame.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{

    @Autowired
    ResultsRepository resultRepository;

    @Autowired
    GamesRepository gamesRepository;

    @Override
    public Results getGameResult(Long gameId) {

        Results results=resultRepository.getReferenceById(gameId);

        return results;
    }
    @Override
    public List<Results> getAllGameResults() {
        return resultRepository.findAll();
    }

    @Override
    public Results createGameResult(Results result, Long gameId) {

        Games game= gamesRepository.findById(gameId).get();

        Results resultsNew  =new  Results();

        resultsNew.setGameResult(result.getGameResult());
        resultsNew.setGame(game);
        resultsNew.setScore(result.getScore());


        return resultRepository.save(resultsNew);
    }
}
