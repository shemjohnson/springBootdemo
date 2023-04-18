package com.example.springBootdemo.controller;

import com.example.springBootdemo.exception.ResourceNotFoundException;
import com.example.springBootdemo.model.Movie;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springBootdemo.repository.MovieRepository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieByid(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie with id: " + id + " not found."));
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/all")
    public String getAllMoviesFromAPI()
    {
        final String uri = "https://gateway.maverik.com/movie/api/movie/title/TITLE?source=web";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/one/{id}")
    public String getOneMovieFromAPI(@PathVariable String id)
    {
        final String uri = "https://gateway.maverik.com/movie/api/movie/"+id+"?source=web";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/imdbid/{imdbid}")
    public ResponseEntity<Movie> findByImdbid(@PathVariable String imdbid) {
        Movie movie = movieRepository.findByImdbid(imdbid);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Movie> findByTitle(@PathVariable String title) {
        Movie movie = movieRepository.findByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/actor/{actors}")
    public ResponseEntity<Movie> findByActors(@PathVariable String actors) {
        Movie movie = movieRepository.findByActors(actors);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<Movie> findByGenre(@PathVariable String genre) {
        System.out.println("This was called" + genre);
        Movie movie = movieRepository.findByGenre(genre);
        return ResponseEntity.ok(movie);
    }

    //http://localhost:8080/api/v1/movies/updateMovie/1/newImdbid/newTitle/newActor/newgenre
    @PostMapping("/updateMovie/{id}/{tempImdbid}/{tempTitle}/{actors}/{genre}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @PathVariable String tempImdbid, @PathVariable String tempTitle, @PathVariable String actors, @PathVariable String genre) {
        movieRepository.updateMovie(id,tempImdbid,tempTitle, actors, genre);
        Movie movie = movieRepository.findByTitle(tempTitle);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("copyIntoDB")
    public String copyDB() throws JSONException {
        String myList = getAllMoviesFromAPI();
        JsonParser springParser = JsonParserFactory.getJsonParser();
        List < Object > list = ((org.springframework.boot.json.JsonParser) springParser).parseList(myList);
        String tempImdbID = "";
        String tempRated = "";
        String tempTitle = "";
        String tempYear = "";
        String tempgenre = "";
        String tempactors = "";
        String tempLanguage = "";
        String tempCountry = "";
        String tempPoster = "";
        String tempImdbRating = "";
        String tempOwner = "";
        String tempRuntime = "";
        String tempPlot = "";

        for (Object o: list) {
            if (o instanceof Map) {
                Map < String, Object > map = (Map < String, Object > ) o;
                System.out.println("Items found: " + map.size());
                int i = 0;

                for (Map.Entry < String, Object > entry: map.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                    if(entry.getKey().toString() == "imdbID"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempImdbID = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "rated"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempRated = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "title"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempTitle = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "year"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempYear = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "genre"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempgenre = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "actors"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempactors = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "plot"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempPlot = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "language"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempLanguage = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "country"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempCountry = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "poster"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempPoster = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "imdbRating"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempImdbRating = entry.getValue().toString();
                            }
                        }
                    }
                    if(entry.getKey().toString() == "owner"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempOwner = entry.getValue().toString();
                            }
                        }
                    }

                    if(entry.getKey().toString() == "runtime"){
                        if(entry != null) {
                            if (entry.getValue() != null) {
                                tempRuntime = entry.getValue().toString();
                            }
                        }
                    }
                    i++;
                }
                System.out.println("Time To Save"+tempImdbID +" "+tempRated +" "+tempTitle+" "+tempYear);
                Movie movie = new Movie();
                movie.setImdbid(tempImdbID);
                movie.setRated(tempRated);
                movie.setTitle(tempTitle);
                movie.setYear(tempYear);
                movie.setGenre(tempgenre);
                movie.setActors(tempactors);
                movie.setLanguage(tempLanguage);
                movie.setCountry(tempCountry);
                movie.setPoster(tempPoster);
                movie.setImdbRating(tempImdbRating);
                movie.setOwner(tempOwner);
                movie.setRuntime(tempRuntime);
                movie.setPlot(tempPlot);
                movieRepository.save(movie);
            }
        }
        return myList;
    }
}
