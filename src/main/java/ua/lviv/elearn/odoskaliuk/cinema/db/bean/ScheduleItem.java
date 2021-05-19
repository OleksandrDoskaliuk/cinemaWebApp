package ua.lviv.elearn.odoskaliuk.cinema.db.bean;

import java.time.LocalDateTime;

import ua.lviv.elearn.odoskaliuk.cinema.db.util.MysqlDateFormatter;


public class ScheduleItem {
	private String movieName;
	private int movieDuration;
	private LocalDateTime startTime;
	private int reservedSeats;
	
	public ScheduleItem() {}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
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
		return "ScheduleItem [movieName=" + movieName + ", movieDuration=" + movieDuration + ", startTime=" + MysqlDateFormatter.getStringFromLocalDateTime(startTime)
				+ ", reservedSeats=" + reservedSeats + "]";
	}
	
}
