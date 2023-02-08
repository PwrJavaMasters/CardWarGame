package com.pwrjavamasters.cardwargame.repositories;

import com.pwrjavamasters.cardwargame.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long> {
}
