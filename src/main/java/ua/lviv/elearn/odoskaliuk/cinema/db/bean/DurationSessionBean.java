package ua.lviv.elearn.odoskaliuk.cinema.db.bean;

import java.time.LocalTime;

public class DurationSessionBean {
	LocalTime startTime;
	int duration;
	public DurationSessionBean() {}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
