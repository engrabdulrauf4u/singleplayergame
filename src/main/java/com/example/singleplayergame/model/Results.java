package com.example.singleplayergame.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;




@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @Column(name = "game_result")
    private String gameResult;

    @Column(name = "score")
    private Long score;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id", nullable=true)
    private Games game;

}
