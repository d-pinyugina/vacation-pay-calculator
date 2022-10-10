package ru.nf.test.vacationpaycalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nf.test.vacationpaycalculator.service.VacationPayCalculatorService;
import ru.nf.test.vacationpaycalculator.service.VacationPayCalculatorServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacationPayCalcWithoutHolidaysApplicationTests {

	private final VacationPayCalculatorService vacationPayCalculatorService = new VacationPayCalculatorServiceImpl();

	@Test
	@DisplayName("Проверка расчета отпускных без учета праздничных дней")
	void vacationPayCalcWithoutHolidaysSuccess() {
		BigDecimal actual = vacationPayCalculatorService.vacationCalc(BigDecimal.valueOf(40000), 3);
		assertEquals(BigDecimal.valueOf(4095), actual);
	}

}
