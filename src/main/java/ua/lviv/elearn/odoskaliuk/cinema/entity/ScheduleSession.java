package ua.lviv.elearn.odoskaliuk.cinema.entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import ua.lviv.elearn.odoskaliuk.cinema.db.util.MysqlDateFormatter;

public class ScheduleSession {
	private int sessionId;
	private int movieId;
	private int cinemaHallId;
	private LocalDateTime startTime;
	
	public ScheduleSession() {}

	public ScheduleSession(int sessionId, int movieId, int cinemaHallId, LocalDateTime startTime) {
		super();
		this.sessionId = sessionId;
		this.movieId = movieId;
		this.cinemaHallId = cinemaHallId;
		this.startTime = startTime;
	}
	
	public static ScheduleSession createSession(int sessionId, int movieId, int cinemaHallId, LocalDateTime startTime) {
		return new ScheduleSession(sessionId, movieId, cinemaHallId, startTime);
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getCinemaHallId() {
		return cinemaHallId;
	}

	public void setCinemaHallId(int cinemaHallId) {
		this.cinemaHallId = cinemaHallId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinemaHallId;
		result = prime * result + movieId;
		result = prime * result + sessionId;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ScheduleSession)) {
			return false;
		}
		ScheduleSession scheduleSession = (ScheduleSession) obj;
		return scheduleSession.startTime.equals(getStartTime());
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", movieId=" + movieId + ", cinemaHallId=" + cinemaHallId
				+ ", startTime=" + MysqlDateFormatter.getStringFromLocalDateTime(startTime) + "]";
	}
	
	
	
	
}
