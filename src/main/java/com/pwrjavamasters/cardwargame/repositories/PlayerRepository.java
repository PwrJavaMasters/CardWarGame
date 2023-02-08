package com.pwrjavamasters.cardwargame.repositories;

import com.pwrjavamasters.cardwargame.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
