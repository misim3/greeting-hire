package com.misim.greetinghire.domain.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("SELECT p " +
            "FROM Position p " +
            "ORDER BY p.id DESC")
    Stream<Position> findAllDesc();
}