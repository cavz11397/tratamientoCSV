package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.inter.PlayerReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class PlayerListController {

    @Autowired
    private PlayerReactiveRepository playerReactiveRepository;

    @GetMapping("/list-players-reactive")
    public String listUsersReactive(Model model)
    {
        Flux<Player> userFlux = playerReactiveRepository.findAll().delayElements(Duration.ofSeconds(1));
        model.addAttribute("players", new ReactiveDataDriverContextVariable(userFlux, 1));
        return "players";
    }
}
