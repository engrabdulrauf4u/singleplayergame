package com.example.singleplayergame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "GAMES")
@Getter
@Setter
@NoArgsConstructor
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Column
    private String gameName;

    @Column
    private Date gameDate;

    @Column
    private String gameVenue;


    @ManyToOne
    private Profiles profiles;

    @OneToMany(mappedBy = "games" , targetEntity = Results.class,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Results> results;


    public void addResults(Results result){
        results.add(result);
        result.setGames(this);
    }

    public void removeResults(Results result){
        results.remove(result);
        result.setGames(null);
    }

    public Games(Long gameId, String gameName, Date gameDate, String gameVenue, Profiles profiles, List<Results> results) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDate = gameDate;
        this.gameVenue = gameVenue;
        this.profiles = profiles;
        this.results.add((Results) results);
    }
}
