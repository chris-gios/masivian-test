package com.masivian.test.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roulette")
public class Roulette {

    @Id
    private String id;
    private boolean open;

}
