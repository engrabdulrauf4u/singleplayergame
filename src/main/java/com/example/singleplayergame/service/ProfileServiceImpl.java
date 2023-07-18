package com.example.singleplayergame.service;

import com.example.singleplayergame.model.Profiles;
import com.example.singleplayergame.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements  ProfileService{

    @Autowired
    ProfileRepository profileRepository;


    @Override
    public ResponseEntity saveProfile(Profiles profile) {
        Profiles profileSaved=null;

        if(profile.getProfileId()!=null)
        {
            return new ResponseEntity("Please dont provide profileId to create profile ",HttpStatus.BAD_REQUEST);

        }else {
            try{
                profileSaved = profileRepository.save(profile);
            }catch(Exception exception){
                return new ResponseEntity(" "+exception.getMessage(),HttpStatus.BAD_REQUEST);

            }

        }

       return new ResponseEntity(profileSaved,HttpStatus.OK);

    }

    @Override
    public ResponseEntity findById(Long id) {

        Profiles profile=null;
        try{
             profile= profileRepository.findById(id).get();
        }catch(Exception ex){

            return new ResponseEntity("No Records Found for profileId " + id, HttpStatus.NOT_FOUND);

        }

          return new ResponseEntity(profile, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Profiles>> findAllProfiles() {

        ResponseEntity<List<Profiles>> listprofiles=null;
        try{
           listprofiles = (ResponseEntity<List<Profiles>>) profileRepository.findAll();
        }catch (Exception exception){
            new ResponseEntity<>("BAD Request ",HttpStatus.BAD_REQUEST);
        }

        if(listprofiles==null)
        {
          return   new ResponseEntity(" No Records found ",HttpStatus.OK );
        }
        return listprofiles;
    }

    @Override
    public ResponseEntity updateProfile(Profiles profile) {

        try {
                if(profile.getProfileId()!=null){

                    Profiles profiletoUpdate = profileRepository.findById(profile.getProfileId()).get();


                    Profiles profileUpdated = null;
                    if (profiletoUpdate != null) {

                        profiletoUpdate.setAge(profile.getAge());
                        profiletoUpdate.setCellNumber(profile.getCellNumber());
                        profiletoUpdate.setDateOfBirth(profile.getDateOfBirth());
                        profiletoUpdate.setEmail(profile.getEmail());
                        profiletoUpdate.setFirstName(profile.getFirstName());
                        profiletoUpdate.setLastName(profile.getLastName());
                        profiletoUpdate.setPosition(profile.getPosition());
                        profiletoUpdate.setRole(profile.getRole());
                        profiletoUpdate.setUsername(profile.getUsername());

                        profileUpdated = profileRepository.save(profiletoUpdate);
                        return new ResponseEntity(profileUpdated, HttpStatus.OK);
                    } else {
                        return new ResponseEntity("No Records Found" + profile.getProfileId(), HttpStatus.NOT_FOUND);
                    }
                }else{
                    return new ResponseEntity("please Provide profileId to update record " + profile.getProfileId(), HttpStatus.BAD_REQUEST);

                }


        }catch(Exception ex){
            return new ResponseEntity("No Records Found for profileId" + profile.getProfileId(), HttpStatus.NOT_FOUND);

        }
    }

    @Override
    public ResponseEntity updateProfiles(Profiles profile, Long profileId) {

        Profiles profileUpdated=null;

        if(profile.getProfileId()!=null){
            return new ResponseEntity("Dont provide profileid in Body of request "+profileId,HttpStatus.FORBIDDEN);
        }

        Profiles profiletoUpdate = null;

        try{
            profiletoUpdate = profileRepository.findById(profileId).get();
        }catch(Exception ex){
            return new ResponseEntity("Profile Not Found for Id "+profileId,HttpStatus.NOT_FOUND);
        }


        profiletoUpdate.setAge(profile.getAge());
        profiletoUpdate.setCellNumber(profile.getCellNumber());
        profiletoUpdate.setDateOfBirth(profile.getDateOfBirth());
        profiletoUpdate.setEmail(profile.getEmail());
        profiletoUpdate.setFirstName(profile.getFirstName());
        profiletoUpdate.setLastName(profile.getLastName());
        profiletoUpdate.setPosition(profile.getPosition());
        profiletoUpdate.setRole(profile.getRole());
        profiletoUpdate.setUsername(profile.getUsername());

        try{
            profileUpdated= profileRepository.save(profiletoUpdate);
        }catch(Exception exception){
            return new ResponseEntity("Bad Request "+exception.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(profileUpdated,HttpStatus.OK);
    }

    @Override
    public Optional<Profiles> getByUserName(String username) {
        return Optional.empty();
    }
}
