package com.example.springBootdemo.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")


public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "imdbid")
    private String imdbid;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "rated")
    private String rated;

    @Column(name = "released")
    private String released;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @Column(name = "plot")
    private String plot;
    @Column(name = "language")
    private String language;
    @Column(name = "country")
    private String country;
    @Column(name = "poster")
    private String poster;
    @Column(name = "imdbRating")
    private String imdbRating;
    @Column(name = "owner")
    private String owner;
    @Column(name = "runtime")
    private String runtime;
}