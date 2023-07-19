package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ResultService {
    Results getGameResult(Long gameId) throws Exception;

    ResponseEntity getAllGameResults(Long gameId);

    ResponseEntity createGameResult(Results result, Long gameId);
}
