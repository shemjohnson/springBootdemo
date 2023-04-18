package com.example.springBootdemo;

import com.example.springBootdemo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springBootdemo.repository.MovieRepository;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class SpringBootdemoApplication implements CommandLineRunner {

	@Autowired
	private HttpServletRequest httpServletRequest;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootdemoApplication.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		Movie movie = new Movie();
		movie.setId(1);
		movie.setRated("test");
		movie.setImdbid("sdfftest");
		movie.setTitle("test");
		movie.setYear("test");
	}
}
