package com.leonidov.workingcalendar.service.impl;

import com.leonidov.workingcalendar.data.DaysRepository;
import com.leonidov.workingcalendar.data.MonthRepository;
import com.leonidov.workingcalendar.model.Day;
import com.leonidov.workingcalendar.model.Month;
import com.leonidov.workingcalendar.service.MonthService;
import lombok.RequiredArgsConstructor;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
public class MonthServiceImpl implements MonthService {

    private final DaysRepository daysRepository;
    private final MonthRepository monthRepository;

    public short getCountDaysByUserId(UUID id, byte monthNumber, short year) {
        Optional<Month> currentMonth = monthRepository.findMonthByUserIdAndMonthNumberAndYear(id, monthNumber, year);
        return currentMonth.map(Month::getWorkingDaysWorked).orElse((byte) 0);
    }

    public short getCountDaysByWeekendIsTrue(UUID id, byte monthNumber, short year) {
        Optional<Month> currentMonth = monthRepository.findMonthByUserIdAndMonthNumberAndYear(id, monthNumber, year);
        return currentMonth.map(Month::getWeekendsWorked).orElse((byte) 0);
    }

    public void save(UUID id, byte countHours, byte dayNumber, byte monthNumber, short year) {
        Calendar calendar = Calendar.getInstance();

        if (dayNumber == -1)
            dayNumber = (byte) calendar.get(Calendar.DAY_OF_MONTH);
        if (monthNumber == -1)
            monthNumber = (byte) calendar.get(Calendar.MONTH);
        if (year == -1)
            year = (byte) calendar.get(Calendar.YEAR);

        calendar.set(year, monthNumber, dayNumber);
        boolean isWeekend = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;

        daysRepository.save(
                Day.builder()
                        .dayNumber(dayNumber)
                        .month(monthNumber)
                        .year(year)
                        .countHours(countHours)
                        .weekend(isWeekend)
                        .userId(id)
                        .build()
        );

    }
}
