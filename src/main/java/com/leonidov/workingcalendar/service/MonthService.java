package com.leonidov.workingcalendar.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface MonthService {
    short getCountDaysByUserId(UUID id, byte monthNumber, short year);
    short getCountDaysByWeekendIsTrue(UUID id, byte monthNumber, short year);
    void save(UUID id, byte countHours, byte dayNumber, byte monthNumber, short year);
}
