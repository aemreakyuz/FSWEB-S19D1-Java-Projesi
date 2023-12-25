package com.s19d1.s19d1challenge.service;

import com.s19d1.s19d1challenge.dto.ActorResponse;
import com.s19d1.s19d1challenge.dto.MovieResponse;
import com.s19d1.s19d1challenge.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie findById(Long id);
    MovieResponse getById(Long id);
    MovieResponse delete(Long id);
    MovieResponse update(Long id, Movie movie);
    MovieResponse save(Movie movie);
    List<MovieResponse> getAll();
    List<ActorResponse> addActorsToMovie(Movie movie);
}
