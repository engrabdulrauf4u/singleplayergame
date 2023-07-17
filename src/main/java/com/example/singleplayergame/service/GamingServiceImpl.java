package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamingServiceImpl implements  GamingService
{

        @Autowired
        GamesRepository gamingRepository;

        @Override
        public List<Games> getAllGames() {

            return gamingRepository.findAll();
        }

        @Override
        public Games createGame(Games game) {
            Games gameR = gamingRepository.save(game);
            return gameR;
        }

        @Override
        public Long joinForGame(Long id) { // how a player can joi game itseltf
            return null;
        }

        @Override
        public Games updateGame(Games game, Long gameId) {
            Games originalGame = gamingRepository.getById(gameId);

            originalGame.setGameDate(game.getGameDate());
            originalGame.setGameName(game.getGameName());
            originalGame.setGameVenue(game.getGameVenue());
            originalGame.setProfiles(originalGame.getProfiles());

            Games gameUpdated = gamingRepository.save(originalGame);


            return gameUpdated;
        }

        @Override
        public void deleteGame(Long gameId) {

            gamingRepository.deleteById(gameId);
        }
}