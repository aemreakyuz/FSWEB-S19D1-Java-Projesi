package com.s19d1.s19d1challenge.repository;

import com.s19d1.s19d1challenge.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
