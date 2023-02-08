package com.pwrjavamasters.cardwargame.repositories;

import com.pwrjavamasters.cardwargame.model.Card;
import com.pwrjavamasters.cardwargame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}