package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Profiles;
import com.example.singleplayergame.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long registerPlayer(@RequestBody Profiles profile){

       Long id =  profileService.saveProfile(profile);
        return id ;
    }

    //Get Personal Profile.
    @GetMapping(value = "/api/v1/profile",params = {"profileId"})
    public Profiles getPersonalProfile(@RequestParam Long profileId){

        Profiles  profile = profileService.findById(profileId);
        return profile ;
    }

    @PutMapping("/api/v1/profile")// End point to player to update own profile
    public Profiles updateProfile(@RequestBody Profiles profile){

        Profiles profileUpdated = profileService.updateProfile(profile);
        return profileUpdated;
    }

    @GetMapping("/api/v1/admin/profiles")  // find All profiles
    public List<Profiles> findAllProfiles() throws Exception {
        List<Profiles> players=profileService.findAllProfiles();
        return players;
    }
    @PutMapping(value = "/api/v1/admin/profiles/{profileId}")
    public Profiles updatePlayersByAdmin(@RequestBody Profiles profiles,@PathVariable Long profileId) throws Exception {
        Profiles profileUpdated= profileService.updateProfiles(profiles,profileId);
        return profileUpdated;
    }


}
