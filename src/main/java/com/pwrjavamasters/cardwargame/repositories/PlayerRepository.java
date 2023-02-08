package com.pwrjavamasters.cardwargame.repositories;

import com.pwrjavamasters.cardwargame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}