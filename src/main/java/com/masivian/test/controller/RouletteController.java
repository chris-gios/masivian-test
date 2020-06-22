package com.masivian.test.controller;

import com.masivian.test.model.Roulette;
import com.masivian.test.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roulette")
public class RouletteController {

    @Autowired
    private RouletteService rouletteService;

    @GetMapping
    public List<Roulette> findAll() {
        return rouletteService.findAll();
    }

    @PostMapping
    public String create() {
        Roulette newRoulette = rouletteService.create(new Roulette());
        return newRoulette.getId();
    }

}
