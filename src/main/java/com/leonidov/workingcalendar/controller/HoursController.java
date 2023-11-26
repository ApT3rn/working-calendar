package com.leonidov.workingcalendar.controller;

import com.leonidov.workingcalendar.service.HoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/hours/")
@RequiredArgsConstructor
public class HoursController {

    private final HoursService hoursService;

    @GetMapping("getAllHours")
    public float getAllHours(UUID id, byte monthNumber, short year) {
        return hoursService.getAllHours(id, monthNumber, year);
    }

    @GetMapping("getRecycledHours")
    public float getRecycledHours(UUID id, byte monthNumber, short year) {
        return hoursService.getRecycledHours(id, monthNumber, year);
    }

    @GetMapping("getWeekendHours")
    public float getWeekendHours(UUID id, byte monthNumber, short year) {
        return hoursService.getWeekendHours(id, monthNumber, year);
    }
}
