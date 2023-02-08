package com.pwrjavamasters.cardwargame.controllers;

import com.pwrjavamasters.cardwargame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping("/game")
    public String getGamePage(Model model){

        return "game";
    }

    @RequestMapping("/game/new")
    public String startNewGame(){

        gameService.startNewGame();

        return "new game";
    }

}