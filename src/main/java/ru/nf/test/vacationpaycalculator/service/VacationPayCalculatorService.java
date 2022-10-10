package ru.nf.test.vacationpaycalculator.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface VacationPayCalculatorService {

	BigDecimal vacationCalc(BigDecimal averageSalary, long vacationDays);
	BigDecimal vacationCalc(BigDecimal averageSalary, LocalDate vacationStartDate, LocalDate vacationEndDate);
}
