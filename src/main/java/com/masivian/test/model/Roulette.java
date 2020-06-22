package com.masivian.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "roulette")
public class Roulette {

    @Id
    private String id;
    private boolean open;
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Bet> bets = new ArrayList<>();

}
