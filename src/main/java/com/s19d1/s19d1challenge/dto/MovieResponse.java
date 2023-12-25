package com.s19d1.s19d1challenge.dto;

import java.util.List;

public record MovieResponse(String name, String directorName, Double rating, String releaseDate, List<ActorResponse> actorList) {
}
