package com.geekseat.witchsaga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvgKillByWitchDto {

    int yearKilledNumberA;
    int yearKilledNumberB;
    float avgYearKilledNumber;
}
