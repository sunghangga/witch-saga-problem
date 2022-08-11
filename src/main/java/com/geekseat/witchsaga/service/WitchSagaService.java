package com.geekseat.witchsaga.service;

import com.geekseat.witchsaga.dto.AvgKillByWitchDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class WitchSagaService {

    private HashMap<Integer, Integer> listFibonacci = new HashMap<>();

    public int fibonacci(int nDigit) {
        int num1 = 1, num2 = 1;
        int counter = 0;
        int sum = 0;

        // Iterate till counter is nDigit
        while (counter < nDigit) {

            // Sum the number
            sum += num1;

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }

        // Add to hashmap
        listFibonacci.put(nDigit, sum);

        return sum;
    }

    public AvgKillByWitchDto avgKillByWitch(int ageOfDeathA, int yearOfDeathA,
                                            int ageOfDeathB, int yearOfDeathB) {

        int subtractA = yearOfDeathA - ageOfDeathA;
        int subtractB = yearOfDeathB - ageOfDeathB;

        // Check if subtract is not 0 or negative
        if (subtractA > 0 && subtractB > 0) {
            int sumFiboA;
            int sumFiboB;

            // Improve to use hashmap, so no need loop and find solution every request or use redis
            // Check for subtract A
            if (listFibonacci.containsKey(subtractA))
                sumFiboA = listFibonacci.get(subtractA);
            else
                sumFiboA = fibonacci(subtractA);

            // Check for subtract B
            if (listFibonacci.containsKey(subtractB))
                sumFiboB = listFibonacci.get(subtractB);
            else
                sumFiboB = fibonacci(subtractB);

            return new AvgKillByWitchDto(
                    sumFiboA,
                    sumFiboB,
                    ((float) (sumFiboA + sumFiboB) / 2)
            );
        }

        throw new RuntimeException("Year of Death must be greater than Age of Death!");
    }
}
