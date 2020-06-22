package com.masivian.test.controller;

import com.masivian.test.model.Roulette;
import com.masivian.test.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}/open")
    public ResponseEntity<Object> open(@PathVariable(value = "id") String id) throws Exception {
        Optional<Roulette> ruleta = Optional.ofNullable(rouletteService.findById(id).orElseThrow(() -> new Exception("Rulette with id " + id + "not found")));
        if (ruleta.isPresent()) {
            if (!ruleta.get().isOpen()) {
                ruleta.get().setOpen(true);
                rouletteService.create(ruleta.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
