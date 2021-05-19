package ua.lviv.elearn.odoskaliuk.cinema.db.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MysqlDateFormatter {
	private static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static LocalDateTime getLocalDateTimeFromString(String sqlDate) {
		return LocalDateTime.parse(sqlDate, DATE_FORMATER);
	}
	
	public static String getStringFromLocalDateTime(LocalDateTime dateTime) {
		return DATE_FORMATER.format(dateTime);
	}
}
