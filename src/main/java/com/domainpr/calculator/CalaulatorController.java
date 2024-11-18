package com.domainpr.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CalaulatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/{stringArray}")
    public ResponseEntity<List<Integer>> getStringArray(@PathVariable String stringArray) throws Exception {

        List<Integer> sumOfNum = calculatorService.getStringArray(stringArray);

        return ResponseEntity.ok().body(sumOfNum);
    }
}
