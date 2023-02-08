package com.pwrjavamasters.cardwargame.repositories;

import com.pwrjavamasters.cardwargame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}