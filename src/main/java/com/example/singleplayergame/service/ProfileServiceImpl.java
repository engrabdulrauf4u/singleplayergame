package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Profiles;
import com.example.singleplayergame.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements  ProfileService{

    @Autowired
    ProfileRepository profileRepository;


    @Override
    public Long saveProfile(Profiles profile) {
        Profiles profileSaved = profileRepository.save(profile);
        return profileSaved.getProfileId();
    }

    @Override
    public Profiles findById(Long id) {

        Profiles profile= profileRepository.findById(id).get();
        return profile;
    }

    @Override
    public List<Profiles> findAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profiles updateProfile(Profiles profile) {
        Profiles profiletoUpdate = findById(profile.getProfileId());

        profiletoUpdate.setAge(profile.getAge());
        profiletoUpdate.setCellNumber(profile.getCellNumber());
        profiletoUpdate.setDateOfBirth(profile.getDateOfBirth());
        profiletoUpdate.setEmail(profile.getEmail());
        profiletoUpdate.setFirstName(profile.getFirstName());
        profiletoUpdate.setLastName(profile.getLastName());
        profiletoUpdate.setPosition(profile.getPosition());
        profiletoUpdate.setRole(profile.getRole());
        profiletoUpdate.setUsername(profile.getUsername());

        Profiles profileUpdated= profileRepository.save(profiletoUpdate);
        return profileUpdated;
    }

    @Override
    public Profiles updateProfiles(Profiles profile, Long profileId) {

        Profiles profiletoUpdate = findById(profileId);

        profiletoUpdate.setAge(profile.getAge());
        profiletoUpdate.setCellNumber(profile.getCellNumber());
        profiletoUpdate.setDateOfBirth(profile.getDateOfBirth());
        profiletoUpdate.setEmail(profile.getEmail());
        profiletoUpdate.setFirstName(profile.getFirstName());
        profiletoUpdate.setLastName(profile.getLastName());
        profiletoUpdate.setPosition(profile.getPosition());
        profiletoUpdate.setRole(profile.getRole());
        profiletoUpdate.setUsername(profile.getUsername());

        Profiles profileUpdated= profileRepository.save(profiletoUpdate);
        return profileUpdated;
    }

    @Override
    public Optional<Profiles> getByUserName(String username) {
        return Optional.empty();
    }
}
