package com.leonidov.workingcalendar.data;

import com.leonidov.workingcalendar.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DaysRepository extends JpaRepository<Day, Long> {
    List<Day> findDaysByUserId(UUID id, byte monthNumber, short year);
    List<Day> findDaysByWeekendIsTrue(UUID id, byte monthNumber, short year);
}
