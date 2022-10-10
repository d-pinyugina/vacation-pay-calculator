package ru.nf.test.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Set;

@Service
public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService {
	// Среднемесячное число календарных дней
	private final static BigDecimal MONTHLY_AVERAGE_NUMBER_OF_CALENDAR_DAYS = BigDecimal.valueOf(29.3);

	private final static Set<LocalDate> HOLIDAYS = Set.of(
			LocalDate.of(2022, 1, 1),
			LocalDate.of(2022, 1, 2),
			LocalDate.of(2022, 1, 3),
			LocalDate.of(2022, 1, 4),
			LocalDate.of(2022, 1, 5),
			LocalDate.of(2022, 1, 6),
			LocalDate.of(2022, 1, 7),
			LocalDate.of(2022, 1, 8),
			LocalDate.of(2022, 2, 23),
			LocalDate.of(2022, 3, 8),
			LocalDate.of(2022, 5, 1),
			LocalDate.of(2022, 5, 9),
			LocalDate.of(2022, 6, 12),
			LocalDate.of(2022, 11, 4)
	);

	/**
	 * Метод для расчета отпускных без учета выходных и праздничных дней по формуле:
	 * Отпускные = (средняя з/п / 29.3) * кол-во отпускных дней
	 *
	 * @param averageSalary Средняя з/п за 12 мес. работы
	 * @param vacationDays  кол-во отпускных дней
	 * @return Сумма отпускных без учета НДФЛ
	 */
	@Override
	public BigDecimal vacationCalc(BigDecimal averageSalary, long vacationDays) {
		return averageSalary
				.divide(MONTHLY_AVERAGE_NUMBER_OF_CALENDAR_DAYS, RoundingMode.HALF_EVEN)
				.multiply(BigDecimal.valueOf(vacationDays));
	}

	/**
	 * Метод для расчета отпускных с учетом выходных и праздничных дней
	 *
	 * @param averageSalary     Средняя з/п за 12 мес. работы
	 * @param vacationStartDate Дата начала отпуска
	 * @param vacationEndDate   Дата завершения отпуска
	 * @return Сумма отпускных
	 */
	@Override
	public BigDecimal vacationCalc(BigDecimal averageSalary,
	                               LocalDate vacationStartDate,
	                               LocalDate vacationEndDate) {
		long vacationDays = vacationStartDate.datesUntil(vacationEndDate.plusDays(1))
				.filter(date -> !HOLIDAYS.contains(date))
				.count();
		return vacationCalc(averageSalary, vacationDays);
	}
}
