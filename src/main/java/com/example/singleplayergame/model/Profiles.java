package com.example.singleplayergame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

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


    @Column(name = "user_name")
    private String username;


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
