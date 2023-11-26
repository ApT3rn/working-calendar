package com.leonidov.workingcalendar.controller;

import com.leonidov.workingcalendar.service.MonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/days/")
@RequiredArgsConstructor
public class MonthController {

    private final MonthService monthService;

    @GetMapping("getCountAllDays")
    public int getCountAllDaysWorked(UUID id, byte monthNumber, short year) {
        return monthService.getCountDaysByUserId(id, monthNumber, year);
    }

    @GetMapping("getCountAllWeekends")
    public int getCountAllWeekendsWorked(UUID id, byte monthNumber, short year) {
        return monthService.getCountDaysByWeekendIsTrue(id, monthNumber, year);
    }

    @PutMapping("addNewDay")
    public void addNewDay(UUID id, byte countHours, byte dayNumber, byte monthNumber, short year) {
        monthService.save(id, countHours, dayNumber, monthNumber, year);
    }
}
