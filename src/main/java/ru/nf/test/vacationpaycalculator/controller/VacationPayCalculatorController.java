package ru.nf.test.vacationpaycalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Интерфейс для расчета отпускных
 */
@RequestMapping(value = "/calculate")
public interface VacationPayCalculatorController {

	@GetMapping
	BigDecimal calculate(@RequestParam BigDecimal averageSalary,
	                     @RequestParam(required = false) Long vacationDays,
	                     @RequestParam(required = false) LocalDate vacationStartDate,
	                     @RequestParam(required = false) LocalDate vacationEndDate
	);
}
