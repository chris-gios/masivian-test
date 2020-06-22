package com.masivian.test.model;

import org.springframework.data.annotation.Id;

public class Bet {

    @Id
    private String id;
    private double value;
    private String betType;
    private String color;
    private int number;
}
