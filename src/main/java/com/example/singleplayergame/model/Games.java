package com.example.singleplayergame.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GAMES")
@Getter
@Setter
@NoArgsConstructor
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Column
    private String gameName;

    @Column
    private Date gameDate;

    @Column
    private String gameVenue;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profiles profiles;

    @OneToMany(mappedBy = "games" , targetEntity = Results.class,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Results> results =  new ArrayList<Results>();


    public Games(Long gameId, String gameName, Date gameDate, String gameVenue, Profiles profiles, List<Results> results) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDate = gameDate;
        this.gameVenue = gameVenue;
        this.profiles = profiles;
        this.results = results;
    }
}
