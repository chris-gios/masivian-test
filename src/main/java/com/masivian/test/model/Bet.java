package com.masivian.test.model;

import com.masivian.test.validators.ValidateString;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "bets")
@TypeAlias(value = "Bet")
public class Bet {

    @Id
    private String id;
    @NotNull
    @Min(value = 0, message = "min value = 0")
    @Max(value = 10000, message = "max value = 10000")
    private double value;
    @NotNull
    @ValidateString(acceptedValues = {"numero", "color"}, message = "value is invalid, available values included { numero, color }")
    private String betType;
    @NotNull
    @ValidateString(acceptedValues = {"negro", "rojo"}, message = "value is invalid, available values included { negro, rojo }")
    private String color;
    @Min(value = 0, message = "min value = 0")
    @Max(value = 36, message = "max value = 36")
    private int number;
}
