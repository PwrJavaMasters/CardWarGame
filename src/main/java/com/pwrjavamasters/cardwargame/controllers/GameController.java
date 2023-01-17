package com.pwrjavamasters.cardwargame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    @RequestMapping("/game")
    public String getGamePage(Model model){

        return "game";
    }
}
