package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Games;
import com.example.singleplayergame.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamingServiceImpl implements  GamingService
{

        @Autowired
        GamesRepository gamingRepository;

        @Override
        public ResponseEntity getAllGames() {

            ResponseEntity<List<Games>> gamesList=null;

            try{
                gamesList =  (ResponseEntity<List<Games>>) gamingRepository.findAll();
            }catch (Exception exception){
                new ResponseEntity<>("BAD Request ",HttpStatus.BAD_REQUEST);
            }

            if(gamesList==null)
            {
                return   new ResponseEntity(" No Records found ", HttpStatus.OK );
            }

            return gamesList;
        }

        @Override
        public ResponseEntity createGame(Games game) {

            Games gameSaved=null;

            if(game.getGameId()!=null)
            {
                return new ResponseEntity("Please dont provide gameId to create Game ",HttpStatus.BAD_REQUEST);

            }if(game.getProfiles()==null)
            {
                return new ResponseEntity("Please  provide Profile Data ",HttpStatus.BAD_REQUEST);

            }if(game.getProfiles().getProfileId()==null)
            {
                return new ResponseEntity("Please  provide Profile Id ",HttpStatus.BAD_REQUEST);

            }else {
                try{
                    gameSaved = gamingRepository.save(game);
                }catch(Exception exception){
                    return new ResponseEntity(" "+exception.getMessage(),HttpStatus.BAD_REQUEST);

                }

            }

            return new ResponseEntity(gameSaved,HttpStatus.OK);

        }

        @Override
        public Long joinForGame(Long id) { // how a player can joi game itseltf
            return null;
        }

        @Override
        public ResponseEntity updateGame(Games game, Long gameId) {

            if(gameId==0 ||  gameId==null)
            {
                return new ResponseEntity("Please  provide Game Id ",HttpStatus.BAD_REQUEST);

            }

            if(game.getGameId()!=null)
            {
                return new ResponseEntity("Please don't provide Game Id in body ",HttpStatus.BAD_REQUEST);

            }

            Games originalGame =null;

            try
            {
                originalGame =  gamingRepository.findById(gameId).get();
            }catch(Exception exception){
                return new ResponseEntity("Data not found against id "+gameId,HttpStatus.BAD_REQUEST);

            }
            originalGame.setGameDate(game.getGameDate());
            originalGame.setGameName(game.getGameName());
            originalGame.setGameVenue(game.getGameVenue());
            originalGame.setProfiles(originalGame.getProfiles());

            Games gameUpdated = gamingRepository.save(originalGame);


            return new ResponseEntity(gameUpdated,HttpStatus.OK);
        }

        @Override
        public ResponseEntity deleteGame(Long gameId) {

            try
            {
                gamingRepository.deleteById(gameId);
            }catch (Exception ex){

                return new ResponseEntity("No data found against Id"+gameId,HttpStatus.NOT_FOUND);
            }


            return new ResponseEntity("data deleted",HttpStatus.OK);
        }
}