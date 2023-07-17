package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Profiles;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfileService {
    List<Profiles> findAllProfiles();

    Long saveProfile(Profiles players);

    Profiles findById(Long id);

    Profiles updateProfile(Profiles players);
    Profiles updateProfiles(Profiles players,Long id);
    Optional<Profiles> getByUserName(String username);
}
