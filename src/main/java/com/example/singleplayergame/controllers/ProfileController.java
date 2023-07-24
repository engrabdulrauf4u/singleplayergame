package com.example.singleplayergame.controllers;

import com.example.singleplayergame.model.Profiles;
import com.example.singleplayergame.model.dto.AuthRequest;
import com.example.singleplayergame.service.JwtService;
import com.example.singleplayergame.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {


    @Autowired
    public ProfileService profileService;

   @Autowired
    private JwtService jwtService;


   @Autowired
   private AuthenticationManager authenticationManager;

    @GetMapping("/home")
    public String home(){

        return "home";
    }

    @PostMapping("/authenticateAndGetToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception {

       Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );

        if (authentication.isAuthenticated())
        {
           return jwtService.generateToken(authRequest.getUsername());

        }else
        {
        throw  new Exception("invalid user name ");
        }
    }

    @PostMapping("/register")   //Register a new player.
    public ResponseEntity registerPlayer(@RequestBody Profiles profile){

       ResponseEntity id =  profileService.saveProfile(profile);
        return id ;
    }

    //Get Personal Profile.
    @GetMapping(value = "/profile",params = {"profileId"})
    public ResponseEntity getPersonalProfile(@RequestParam Long profileId){

        ResponseEntity profile = profileService.findById(profileId);
        return profile ;
    }

    @PutMapping("/profile")// End point to player to update own profile
    public ResponseEntity updateProfile(@RequestBody Profiles profile) throws Exception {

        ResponseEntity profileUpdated = profileService.updateProfile(profile);
        return profileUpdated;
    }

    @GetMapping("/admin/profiles")  // find All profiles
    public ResponseEntity<List<Profiles>> findAllProfiles() throws Exception {
        ResponseEntity<List<Profiles>> players=profileService.findAllProfiles();
        return players;
    }
    @PutMapping(value = "/admin/profiles/{profileId}")
    public ResponseEntity updatePlayersByAdmin(@RequestBody Profiles profiles,@PathVariable Long profileId) throws Exception {
        ResponseEntity profileUpdated= profileService.updateProfiles(profiles,profileId);
        return profileUpdated;
    }


}
