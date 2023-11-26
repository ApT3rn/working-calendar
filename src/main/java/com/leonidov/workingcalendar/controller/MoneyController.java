package com.leonidov.workingcalendar.controller;

import com.leonidov.workingcalendar.service.MoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/money/")
@RequiredArgsConstructor
public class MoneyController {

    private final MoneyService moneyService;

    @GetMapping("getAmountPerMonth")
    public float getAmountOfMoneyEarnedPerMonth(UUID id, byte monthNumber, short year) {
        return moneyService.getAmountOfMoneyEarnedPerMonth(id, monthNumber, year);
    }

    @GetMapping("getAmountPerMonthWithTheNorm")
    public float getAmountOfMoneyEarnedPerMonthWithTheNorm(UUID id, byte monthNumber, short year) {
        return moneyService.getAmountOfMoneyEarnedPerMonthWithTheNorm(id, monthNumber, year);
    }

    @GetMapping("getAmountOverTheWeekend")
    public float getAmountOfMoneyOverTheWeekend(UUID id, byte monthNumber, short year) {
        return moneyService.getAmountOfMoneyOverTheWeekend(id, monthNumber, year);
    }

    @GetMapping("getAmountForRecycledWatches")
    public float getAmountOfMoneyForRecycledWatches(UUID id, byte monthNumber, short year) {
        return moneyService.getAmountOfMoneyForRecycledWatches(id, monthNumber, year);
    }
}
