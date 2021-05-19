package ua.lviv.elearn.odoskaliuk.cinema.db.bean;

import java.time.LocalDateTime;

import ua.lviv.elearn.odoskaliuk.cinema.db.util.MysqlDateFormatter;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.TimeDurationFormatter;


public class ScheduleItem {
	private String movieName;
	private String movieDuration;
	private String startTime;
	private int reservedSeats;
	
	public ScheduleItem() {}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(int movieDuration) {
		this.movieDuration = TimeDurationFormatter.getStringFromTimeDuration(movieDuration);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	@Override
	public String toString() {
		return "ScheduleItem [movieName=" + movieName + ", movieDuration=" + movieDuration + ", startTime=" + startTime
				+ ", reservedSeats=" + reservedSeats + "]";
	}
	
}
