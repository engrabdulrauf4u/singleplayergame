package com.example.singleplayergame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "PLAYERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id", nullable = false)
    private Long profileId;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "role")
    private String role;

    @Column(name = "email" , unique=true)
    private String email;



    @Column(name = "password")
    private String password;

    @Column(name = "position")
    private String position;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "cell_number")
    private String cellNumber;


    @Column(name = "user_name" , unique=true)
    private String username;

    @OneToMany(mappedBy = "profiles" , targetEntity = Games.class,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Games> games;

    public Profiles(Long profileId, String firstName, String lastName, int age, String role, String email, String password, String position, Date dateOfBirth, String cellNumber, String username,Games game) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role=role;
        this.email = email;
        this.password = password;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.cellNumber = cellNumber;
        this.username = username;
        this.games.add(game);

    }

    public void addGames(Games game){
        games.add(game);
        game.setProfiles(this);
    }

    public void removeGames(Games game){
        games.remove(game);
        game.setProfiles(null);
    }


    
    @Override
    public String toString() {
        return "Profiles{" +
                "profileId=" + profileId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cellNumber='" + cellNumber + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
