package com.example.singleplayergame.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @Column(name = "game_result")
    private String gameResult;

    @Column(name = "score")
    private Long score;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games games;

    public Results(Long resultId, String gameResult, Long score, Games games) {
        this.resultId = resultId;
        this.gameResult = gameResult;
        this.score = score;
        //this.games = games;
    }
}
