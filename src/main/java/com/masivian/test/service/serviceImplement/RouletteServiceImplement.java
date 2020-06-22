package com.masivian.test.service.serviceImplement;

import com.masivian.test.model.Roulette;
import com.masivian.test.repository.RouletteRepository;
import com.masivian.test.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouletteServiceImplement implements RouletteService {

    @Autowired
    private RouletteRepository rouletteRepository;


    @Override
    public Roulette create(Roulette roulette) {
        return rouletteRepository.save(roulette);
    }

    @Override
    public Roulette update(Roulette roulette) {
        return rouletteRepository.save(roulette);
    }

    @Override
    public List<Roulette> findAll() {
        return rouletteRepository.findAll();
    }

    @Override
    public Optional<Roulette> findById(String id) {
        return rouletteRepository.findById(id);
    }
}
