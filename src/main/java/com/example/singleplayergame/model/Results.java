package com.example.singleplayergame.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;




@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @Column(name = "game_result")
    private String gameResult;

    @Column(name = "score")
    private Long score;

    @ManyToOne
    private Games games;

    public Results(Long resultId, String gameResult, Long score, Games games) {
        this.resultId = resultId;
        this.gameResult = gameResult;
        this.score = score;
        this.games = games;
    }
}
