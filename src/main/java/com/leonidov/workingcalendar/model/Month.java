package com.leonidov.workingcalendar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Month implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private byte monthNumber;
    private short year;
    private byte workingDaysWorked;
    private byte weekendsWorked;
    private float HoursWorkedInAccordanceWithTheNorm;
    private float HoursOfOvertimeWorked;
    private float weekendHoursWorked;
    private float EarningsForAMonthAccordingToTheNorm;
    private float EarningsForAMonthWithoutOvertime;
    private float EarningsForAMonthWithoutWeekends;
    private UUID userId;
}
