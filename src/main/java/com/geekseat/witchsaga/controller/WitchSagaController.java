package com.geekseat.witchsaga.controller;

import com.geekseat.witchsaga.dto.AvgKillByWitchDto;
import com.geekseat.witchsaga.service.WitchSagaService;
import com.geekseat.witchsaga.util.ResponseMessage;
import com.geekseat.witchsaga.validation.AvgKillByWitchValidation;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@ApiOperation("Witch Saga API")
public class WitchSagaController {

    private WitchSagaService witchSagaService;
    private HttpHeaders headers;

    @Autowired
    public WitchSagaController (WitchSagaService witchSagaService) {
        this.witchSagaService = witchSagaService;
    }

    /**
     * Get average response killed people by the witch
     * @param avgKillByWitchValidation Use to save params and validate it
     * @param bindingResult Use to check error input parameter
     * @return Average killed people by the witch
     */
    @ApiOperation(value = "Get average kill by witch", notes = "Returns average people killed by witch")
    @GetMapping(path = "api/avg-kill-by-witch", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> avgKillByWitch (@Validated AvgKillByWitchValidation avgKillByWitchValidation,
                                                             BindingResult bindingResult) {

        // Set headers
        headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                    ResponseMessage.exceptionErrorJson(
                            HttpStatus.BAD_REQUEST.value(),
                            bindingResult
                                    .getFieldErrors()
                                    .stream()
                                    .map(f -> (f.getField() + ": " + f.getDefaultMessage()))
                                    .collect(Collectors.toList())
                    ),
                    headers,
                    HttpStatus.BAD_REQUEST
            );
        }

        try {
            AvgKillByWitchDto response = witchSagaService.avgKillByWitch(
                    avgKillByWitchValidation.getAgeOfDeathA(),
                    avgKillByWitchValidation.getYearOfDeathA(),
                    avgKillByWitchValidation.getAgeOfDeathB(),
                    avgKillByWitchValidation.getYearOfDeathB()
            );

            return new ResponseEntity<>(
                    ResponseMessage.retrieveDataJson(
                            HttpStatus.OK.value(),
                            "Retrieved data successfully.",
                            response
                    ),
                    headers,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    ResponseMessage.exceptionErrorJson(
                            HttpStatus.BAD_REQUEST.value(),
                            e.getMessage()
                    ),
                    headers,
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
