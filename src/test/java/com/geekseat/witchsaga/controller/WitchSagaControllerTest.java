package com.geekseat.witchsaga.controller;

import com.geekseat.witchsaga.service.WitchSagaService;
import com.geekseat.witchsaga.validation.AvgKillByWitchValidation;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WitchSagaControllerTest {

    @Test
    void givenResponseNoError_whenRequestWithCorrectParam_then200IsReceived() {
        WitchSagaController witchSagaController = new WitchSagaController(new WitchSagaService());
        ResponseEntity<Object> response = witchSagaController.avgKillByWitch(
                new AvgKillByWitchValidation(
                        9, 10, 11, 12
                ),
                new MapBindingResult(new HashMap<>(), "validation")
        );
        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    void givenResponseError_whenParamYearGreaterThanAge_then400IsReceived() {
        WitchSagaController witchSagaController = new WitchSagaController(new WitchSagaService());
        ResponseEntity<Object> response = witchSagaController.avgKillByWitch(
                new AvgKillByWitchValidation(
                        11, 10, 11, 12
                ),
                new MapBindingResult(new HashMap<>(), "validation")
        );
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode().value());
    }
}