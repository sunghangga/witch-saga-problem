package com.geekseat.witchsaga.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvgKillByWitchValidation {

    @NotNull
    @Min(1)
    int ageOfDeathA;
    @NotNull
    @Min(1)
    int yearOfDeathA;
    @NotNull
    @Min(1)
    int ageOfDeathB;
    @NotNull
    @Min(1)
    int yearOfDeathB;
}
