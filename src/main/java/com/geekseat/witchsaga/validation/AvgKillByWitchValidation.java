package com.geekseat.witchsaga.validation;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvgKillByWitchValidation {

    @Min(1)
    @NotNull
    @ApiParam(
            name =  "ageOfDeathA",
            value = "Age of Death Person A",
            example = "9")
    int ageOfDeathA;

    @Min(1)
    @NotNull
    @ApiParam(
            name =  "yearOfDeathA",
            value = "Year of Death Person A",
            example = "10")
    int yearOfDeathA;

    @Min(1)
    @NotNull
    @ApiParam(
            name =  "ageOfDeathB",
            value = "Age of Death Person B",
            example = "11")
    int ageOfDeathB;

    @Min(1)
    @NotNull
    @ApiParam(
            name =  "yearOfDeathB",
            value = "Year of Death Person B",
            example = "12")
    int yearOfDeathB;
}
