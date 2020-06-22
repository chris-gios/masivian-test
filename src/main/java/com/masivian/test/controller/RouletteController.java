package com.masivian.test.controller;

import com.masivian.test.exception.business.RouletteClosedException;
import com.masivian.test.exception.business.RouletteNotFoundException;
import com.masivian.test.model.Bet;
import com.masivian.test.model.Roulette;
import com.masivian.test.service.BetService;
import com.masivian.test.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roulette")
public class RouletteController {

    private static final String ROULETTE_DOES_NOT_EXIST_MESSAGE = "Roulette with id %s does not exist";

    @Autowired
    private RouletteService rouletteService;

    @Autowired
    private BetService betService;

    @GetMapping
    public ResponseEntity<List<Roulette>> findAll() {
        return new ResponseEntity<>(rouletteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Roulette> create() {
        Roulette newRoulette = rouletteService.create(new Roulette());
        return new ResponseEntity<>(newRoulette, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/open")
    public ResponseEntity<Object> open(@PathVariable(value = "id") String id) throws RouletteNotFoundException {
        Optional<Roulette> ruleta = Optional.ofNullable(rouletteService.findById(id).orElseThrow(() -> new RouletteNotFoundException(String.format(ROULETTE_DOES_NOT_EXIST_MESSAGE, id))));
        if (ruleta.isPresent()) {
            if (!ruleta.get().isOpen()) {
                ruleta.get().setOpen(true);
                rouletteService.update(ruleta.get());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping("/{id}/bet")
    public ResponseEntity<Bet> makeBet(@RequestHeader(value = "user-id") String userId, @PathVariable(value = "id") String id, @Valid @RequestBody Bet bet) throws RouletteNotFoundException, RouletteClosedException {
        Optional<Roulette> ruleta = Optional.ofNullable(rouletteService.findById(id).orElseThrow(() -> new RouletteNotFoundException(String.format(ROULETTE_DOES_NOT_EXIST_MESSAGE, id))));
        if (ruleta.isPresent()) {
            if (ruleta.get().isOpen()) {
                Bet newBet = betService.create(bet);
                ruleta.get().getBets().add(newBet);
                rouletteService.update(ruleta.get());
                return new ResponseEntity<>(bet, HttpStatus.CREATED);
            } else {
                throw new RouletteClosedException(String.format("Roulette with id %s is closed, it must be open to bet", id));
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<List<Bet>> close(@PathVariable(value = "id") String id) throws RouletteNotFoundException {
        Optional<Roulette> ruleta = Optional.ofNullable(rouletteService.findById(id).orElseThrow(() -> new RouletteNotFoundException(String.format(ROULETTE_DOES_NOT_EXIST_MESSAGE, id))));
        if (ruleta.isPresent()) {
            if (ruleta.get().isOpen()) {
                ruleta.get().setOpen(false);
                rouletteService.update(ruleta.get());
            }
            return new ResponseEntity<>(ruleta.get().getBets(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
