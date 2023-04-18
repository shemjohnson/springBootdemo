package com.example.springBootdemo.repository;

import com.example.springBootdemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByImdbid(String imdbid);
    Movie findByTitle(String title);
    Movie findByActors(String actors);
    Movie findByGenre(String genre);
    Movie findById(String id);

    @Transactional
    @Modifying
    @Query("update Movie m set m.imdbid = :imdbid, m.title = :title, m.actors = :actors, m.genre = :genre where m.id = :id")
    void updateMovie(@Param(value = "id") long id, @Param(value = "imdbid") String imdbid, @Param(value = "title") String title, @Param(value = "actors") String actors, @Param(value = "genre") String genre);


}

