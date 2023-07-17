package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GamingService {

    List<Games> getAllGames();

    Games createGame(Games game);

    Long joinForGame(Long id);

    Games updateGame(Games game, Long gameId);

    void deleteGame(Long gameId);
}
