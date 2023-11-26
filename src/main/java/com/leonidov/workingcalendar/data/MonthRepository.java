package com.leonidov.workingcalendar.data;

import com.leonidov.workingcalendar.model.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {
    Optional<Month> findMonthByUserIdAndMonthNumberAndYear(UUID id, byte monthNumber, short year);
    Optional<Month> findMonthByMonthNumberAndYear(byte monthNumber, short year);
}
