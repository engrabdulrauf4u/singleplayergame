package com.example.singleplayergame.repository;

import com.example.singleplayergame.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ResultsRepository extends JpaRepository<Results,Long> {
}
