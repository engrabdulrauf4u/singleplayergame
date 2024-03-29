package com.example.singleplayergame.repository;

import com.example.singleplayergame.model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ProfileRepository extends JpaRepository<Profiles,Long> {
    Optional<Profiles> findByUsername(String username);
}
