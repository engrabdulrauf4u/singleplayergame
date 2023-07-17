package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Results;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    Results getGameResult(Long gameId);

    List<Results> getAllGameResults();

    Results createGameResult(Results result, Long gameId);
}
