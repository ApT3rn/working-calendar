package com.leonidov.workingcalendar.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface MoneyService {
    float getAmountOfMoneyEarnedPerMonth(UUID id, byte monthNumber, short year);
    float getAmountOfMoneyEarnedPerMonthWithTheNorm(UUID id, byte monthNumber, short year);
    float getAmountOfMoneyOverTheWeekend(UUID id, byte monthNumber, short year);
    float getAmountOfMoneyForRecycledWatches(UUID id, byte monthNumber, short year);
}
