package com.s19d1.s19d1challenge.service;

import com.s19d1.s19d1challenge.dto.ActorResponse;
import com.s19d1.s19d1challenge.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor findById(Long id);
    ActorResponse getById(Long id);
    ActorResponse delete(Long id);
    ActorResponse update(Long id, Actor actor);
    ActorResponse save(Actor actor);
    List<ActorResponse> getAll();
}
