package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Profiles;
import com.example.singleplayergame.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {


    @Autowired
    public ProfileService profileService;


    @GetMapping("/home")
    public String home(){

        return "home";
    }

    @PostMapping("/api/v1/register")   //Register a new player.
    public ResponseEntity registerPlayer(@RequestBody Profiles profile){

       ResponseEntity id =  profileService.saveProfile(profile);
        return id ;
    }

    //Get Personal Profile.
    @GetMapping(value = "/api/v1/profile",params = {"profileId"})
    public ResponseEntity getPersonalProfile(@RequestParam Long profileId){

        ResponseEntity profile = profileService.findById(profileId);
        return profile ;
    }

    @PutMapping("/api/v1/profile")// End point to player to update own profile
    public ResponseEntity updateProfile(@RequestBody Profiles profile) throws Exception {

        ResponseEntity profileUpdated = profileService.updateProfile(profile);
        return profileUpdated;
    }

    @GetMapping("/api/v1/admin/profiles")  // find All profiles
    public ResponseEntity<List<Profiles>> findAllProfiles() throws Exception {
        ResponseEntity<List<Profiles>> players=profileService.findAllProfiles();
        return players;
    }
    @PutMapping(value = "/api/v1/admin/profiles/{profileId}")
    public ResponseEntity updatePlayersByAdmin(@RequestBody Profiles profiles,@PathVariable Long profileId) throws Exception {
        ResponseEntity profileUpdated= profileService.updateProfiles(profiles,profileId);
        return profileUpdated;
    }


}
