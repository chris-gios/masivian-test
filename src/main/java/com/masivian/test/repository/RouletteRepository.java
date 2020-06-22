package com.masivian.test.repository;

import com.masivian.test.model.Roulette;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouletteRepository extends MongoRepository<Roulette, String> {

}
