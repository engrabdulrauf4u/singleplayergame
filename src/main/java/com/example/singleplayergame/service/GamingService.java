package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface GamingService {

    ResponseEntity getAllGames();

    ResponseEntity createGame(Games game);

    Long joinForGame(Long id);

    ResponseEntity updateGame(Games game, Long gameId);

    ResponseEntity deleteGame(Long gameId);
}
