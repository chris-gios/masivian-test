package com.masivian.test.service;

import com.masivian.test.model.Roulette;

import java.util.List;
import java.util.Optional;

public interface RouletteService {

    List<Roulette> findAll();

    Optional<Roulette> findById(String id);

    Roulette create(Roulette roulette);

    Roulette update(Roulette roulette);

}
