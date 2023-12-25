package com.s19d1.s19d1challenge.service;

import com.s19d1.s19d1challenge.converter.DtoConverter;
import com.s19d1.s19d1challenge.dto.ActorResponse;
import com.s19d1.s19d1challenge.dto.MovieResponse;
import com.s19d1.s19d1challenge.entity.Movie;
import com.s19d1.s19d1challenge.repository.MovieRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }

    }

    @Override
    public MovieResponse getById(Long id) {
        Movie movie = findById(id);
        return DtoConverter.convertToMovieResponse(movie);
    }

    @Override
    public MovieResponse delete(Long id) {
        Movie willDeleteMovie = findById(id);
        movieRepository.delete(willDeleteMovie);
        return DtoConverter.convertToMovieResponse(willDeleteMovie);
    }

    @Override
    public MovieResponse update(Long id, Movie movie) {
        Movie willUpdateMovie = findById(id);
        willUpdateMovie.setName(movie.getName());
        willUpdateMovie.setDirectorName(movie.getDirectorName());
        willUpdateMovie.setRating(movie.getRating());
        willUpdateMovie.setReleaseDate(movie.getReleaseDate());
        return DtoConverter.convertToMovieResponse(movieRepository.save(willUpdateMovie));
    }

    @Override
    public MovieResponse save(Movie movie) {
        //System.out.println(movie);
        //movie.getActorList().forEach(movie::addActor);

        return DtoConverter.convertToMovieResponse(movieRepository.save(movie));
    }

    @Override
    public List<ActorResponse> addActorsToMovie(Movie movie) {
        movie.getActorList().forEach(movie::addActor);
        return DtoConverter.convertToActorResponseList(movie.getActorList());
    }

    @Override
    public List<MovieResponse> getAll(){
        return DtoConverter.convertToMovieResponseList(movieRepository.findAll());
    }
}
