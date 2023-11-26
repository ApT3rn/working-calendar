package com.leonidov.workingcalendar.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface HoursService {
    float getAllHours(UUID id, byte monthNumber, short year);
    float getRecycledHours(UUID id, byte monthNumber, short year);
    float getWeekendHours(UUID id, byte monthNumber, short year);
}
