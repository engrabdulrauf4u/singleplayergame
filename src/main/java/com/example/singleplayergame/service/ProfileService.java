package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Profiles;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfileService {
    ResponseEntity<List<Profiles>> findAllProfiles();

    ResponseEntity saveProfile(Profiles players);

    ResponseEntity findById(Long id);

    ResponseEntity updateProfile(Profiles players) throws Exception;
    ResponseEntity updateProfiles(Profiles players, Long id);
    Optional<Profiles> getByUserName(String username);
}
