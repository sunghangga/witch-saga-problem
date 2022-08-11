package com.geekseat.witchsaga.service;

import com.geekseat.witchsaga.dto.AvgKillByWitchDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WitchSagaServiceTest {

    @Test
    void givenSumFibonacci_whenDigitMoreThan0_thenSumFibonacciReceived() {
        WitchSagaService witchSagaService = new WitchSagaService();
        int sumFibonacci = witchSagaService.fibonacci(3);
        assertEquals(4, sumFibonacci);
    }

    @Test
    void given0_whenDigitLessOrEqual0_then0Received() {
        WitchSagaService witchSagaService = new WitchSagaService();
        int sumFibonacci = witchSagaService.fibonacci(0);
        assertEquals(0, sumFibonacci);
    }

    @Test
    void givenAverageMoreThan0_whenRequestValidParam_thenValueMoreThan0Received() {
        WitchSagaService service = new WitchSagaService();
        AvgKillByWitchDto avgKillByWitchDto = service.avgKillByWitch(
                9, 10, 11, 12
        );
        assertTrue(0 < avgKillByWitchDto.getAvgYearKilledNumber());
    }

    @Test
    void givenError_whenParamYearGreaterThanAge_thenThrowErrorReceived() {
        WitchSagaService service = new WitchSagaService();
        try {
            service.avgKillByWitch(11, 10, 13, 12);
        } catch (Exception e) {
            assertEquals("Year of Death must be greater than Age of Death!", e.getMessage());
        }
    }
}