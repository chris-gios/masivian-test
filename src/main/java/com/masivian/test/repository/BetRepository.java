package com.masivian.test.repository;

import com.masivian.test.model.Bet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BetRepository extends MongoRepository<Bet, String> {

}
