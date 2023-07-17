package com.example.singleplayergame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "GAMES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long game_id;

    @Column
    private String gameName;

    @Column
    private Date gameDate;

    @Column
    private String gameVenue;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profiles profiles;



}
