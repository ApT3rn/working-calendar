package com.leonidov.workingcalendar.service.impl;

import com.leonidov.workingcalendar.data.MonthRepository;
import com.leonidov.workingcalendar.model.Month;
import com.leonidov.workingcalendar.service.HoursService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class HoursServiceImpl implements HoursService {

    private final MonthRepository monthRepository;

    @Override
    public float getAllHours(UUID id, byte monthNumber, short year) {
        Optional<Month> currentMonth = monthRepository.findMonthByUserIdAndMonthNumberAndYear(id, monthNumber, year);
        return currentMonth.map(c -> c.getHoursWorkedInAccordanceWithTheNorm()
                + c.getWeekendHoursWorked() + c.getHoursOfOvertimeWorked()).orElse(0F);
    }

    @Override
    public float getRecycledHours(UUID id, byte monthNumber, short year) {
            Optional<Month> currentMonth = monthRepository.findMonthByUserIdAndMonthNumberAndYear(id, monthNumber, year);
            return currentMonth.map(Month::getHoursOfOvertimeWorked).orElse(0F);
    }

    @Override
    public float getWeekendHours(UUID id, byte monthNumber, short year) {
            Optional<Month> currentMonth = monthRepository.findMonthByUserIdAndMonthNumberAndYear(id, monthNumber, year);
            return currentMonth.map(Month::getWeekendHoursWorked).orElse(0F);
    }
}
