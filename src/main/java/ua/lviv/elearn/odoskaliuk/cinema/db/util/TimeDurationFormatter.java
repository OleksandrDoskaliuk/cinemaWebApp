package ua.lviv.elearn.odoskaliuk.cinema.db.util;

public class TimeDurationFormatter {
	private TimeDurationFormatter() {}
	public static String getStringFromTimeDuration(int duration) {
		int hours = (int)duration / 3600;
		int remain = duration - (hours * 3600);
		int minutes = (int) remain / 60;
		return String.format("%02d:%02d", hours, minutes);
	}
}
