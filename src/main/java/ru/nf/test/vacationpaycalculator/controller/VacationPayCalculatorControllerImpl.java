package ru.nf.test.vacationpaycalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.nf.test.vacationpaycalculator.exception.InvalidRequestParamsException;
import ru.nf.test.vacationpaycalculator.service.VacationPayCalculatorService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class VacationPayCalculatorControllerImpl implements VacationPayCalculatorController {

	private final VacationPayCalculatorService service;


	@Override
	public BigDecimal calculate(BigDecimal averageSalary, Long vacationDays, LocalDate vacationStartDate,
	                            LocalDate vacationEndDate) {
		if (averageSalary.compareTo(BigDecimal.ZERO) < 0 || vacationDays == null || vacationDays < 0) {
			if (vacationStartDate != null && vacationEndDate != null && vacationStartDate.isBefore(vacationEndDate)) {
				return service.vacationCalc(averageSalary, vacationStartDate, vacationEndDate);
			}
			throw new InvalidRequestParamsException(averageSalary, vacationDays);
		}
		return service.vacationCalc(averageSalary, vacationDays);
	}
}
