package com.masivian.test.service.serviceImplement;

import com.masivian.test.model.Bet;
import com.masivian.test.repository.BetRepository;
import com.masivian.test.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImplement implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public Bet create(Bet bet) {
        return betRepository.save(bet);
    }

}
