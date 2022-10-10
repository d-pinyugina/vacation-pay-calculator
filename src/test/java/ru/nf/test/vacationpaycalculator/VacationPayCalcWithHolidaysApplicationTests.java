package ru.nf.test.vacationpaycalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nf.test.vacationpaycalculator.service.VacationPayCalculatorService;
import ru.nf.test.vacationpaycalculator.service.VacationPayCalculatorServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationPayCalcWithHolidaysApplicationTests {
	private final VacationPayCalculatorService vacationPayCalculatorService = new VacationPayCalculatorServiceImpl();

	@Test
	@DisplayName("Проверка расчета отпускных с учетом праздничных дней")
	void vacationPayCalcWithHolidaysSuccess() {
		//отпуск с 05.03.2022 по 10.03.2022 --> 5 дней оплачиваемых и 1 день праздничный(08.03.2022)
		LocalDate vacationStartDate = LocalDate.of(2022, 3, 5);
		LocalDate vacationEndDate = LocalDate.of(2022, 3, 10);
		BigDecimal actual = vacationPayCalculatorService
				.vacationCalc(BigDecimal.valueOf(40000), vacationStartDate, vacationEndDate);
		assertEquals(BigDecimal.valueOf(6825), actual);
	}
}
