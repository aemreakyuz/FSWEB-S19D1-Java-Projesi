package com.s19d1.s19d1challenge.converter;

import com.s19d1.s19d1challenge.dto.ActorResponse;
import com.s19d1.s19d1challenge.dto.MovieResponse;
import com.s19d1.s19d1challenge.entity.Actor;
import com.s19d1.s19d1challenge.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {
    public static MovieResponse convertToMovieResponse(Movie movie){
        return new MovieResponse(
                movie.getName(),
                movie.getDirectorName(),
                movie.getRating(),
                movie.getReleaseDate(),
                movie.getActorList() == null ? new ArrayList<>() : convertToActorResponseList(movie.getActorList())
        );
    }
    public static List<MovieResponse> convertToMovieResponseList(List<Movie> movieList){
        List<MovieResponse> responses = new ArrayList<>();
        movieList.forEach(movie -> responses.add(new MovieResponse(
                movie.getName(),
                movie.getDirectorName(),
                movie.getRating(),
                movie.getReleaseDate(),
                movie.getActorList() == null ? new ArrayList<>() : convertToActorResponseList(movie.getActorList())
        )));
        return responses;
    }
    public static ActorResponse convertToActorResponse(Actor actor){
        return new ActorResponse(
                actor.getFirstName(),
                actor.getLastName(),
                actor.getGender(),
                actor.getBirthDate()

        );
    }
    public static List<ActorResponse> convertToActorResponseList(List<Actor> actorList){
        List<ActorResponse> responses = new ArrayList<>();
        actorList.forEach(actor -> responses.add(new ActorResponse(
                actor.getFirstName(),
                actor.getLastName(),
                actor.getGender(),
                actor.getBirthDate()

        )));
        return responses;
    }
}
