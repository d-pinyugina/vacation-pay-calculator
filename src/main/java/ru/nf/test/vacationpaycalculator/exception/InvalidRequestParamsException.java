package ru.nf.test.vacationpaycalculator.exception;

import java.math.BigDecimal;

public class InvalidRequestParamsException extends RuntimeException {
	public InvalidRequestParamsException(BigDecimal averageSalary, Long vacationDays) {
		super(String.format("Invalid params: %s, %s", averageSalary, vacationDays));
	}
}
