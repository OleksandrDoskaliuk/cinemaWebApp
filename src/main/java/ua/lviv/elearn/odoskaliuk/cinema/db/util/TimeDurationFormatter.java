package ua.lviv.elearn.odoskaliuk.cinema.db.util;

public class TimeDurationFormatter {
	private TimeDurationFormatter() {}
	public static String getStringFromTimeDuration(int duration) {
		int hours = (int)duration / 3600;
		int remain = duration - (hours * 3600);
		int minutes = (int) remain / 60;
		return String.format("%1d:%02d", hours, minutes);
	}
	
	public static int getDurationFromString(String duration) {
		String[] values = duration.split(":");
		int hours = Integer.valueOf(values[0]);
		int minutes = Integer.valueOf(values[1]);
		return (hours * 3600) + (minutes * 60);
	}
}
