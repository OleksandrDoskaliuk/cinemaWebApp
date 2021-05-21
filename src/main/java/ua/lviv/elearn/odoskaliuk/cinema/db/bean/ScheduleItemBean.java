package ua.lviv.elearn.odoskaliuk.cinema.db.bean;


public class ScheduleItemBean {
	int sessionId;
	String movieName;
	String movieDuration;
	String movieStartTime;
	
	public ScheduleItemBean() {}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieStartTime() {
		return movieStartTime;
	}

	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}

	@Override
	public String toString() {
		return "ScheduleItemBean [sessionId=" + sessionId + ", movieName=" + movieName + ", movieDuration="
				+ movieDuration + ", movieStartTime=" + movieStartTime + "]";
	}
	
	
}
