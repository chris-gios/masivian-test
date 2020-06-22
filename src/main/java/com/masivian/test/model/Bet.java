package com.masivian.test.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Bet {

    @Id
    private String id;
    @NotNull
    @Min(value = 0, message = "min value = 0")
    @Max(value = 10000, message = "max value = 10000")
    private double value;
    @NotNull
    private String betType;
    @NotNull
    private String color;
    @Min(value = 0, message = "min value = 0")
    @Max(value = 36, message = "max value = 36")
    private int number;
}
