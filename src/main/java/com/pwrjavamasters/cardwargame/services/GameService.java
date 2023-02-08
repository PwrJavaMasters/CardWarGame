package com.pwrjavamasters.cardwargame.services;

import org.springframework.stereotype.Service;

public interface GameService {

    public void startNewGame();

    public boolean makeMove();
}