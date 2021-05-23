import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.bean.ScheduleItemBean;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.Constants;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.MysqlDateFormatter;

public class Demo {
	public static void main(String[] args) {
		Bean b1 = new Bean(LocalTime.of(12, 30), LocalTime.of(2, 0));
		Bean b2 = new Bean(LocalTime.of(16, 30), LocalTime.of(1, 40));
		
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(22, 0);
		LocalTime cleaningTime = LocalTime.of(0, 15);
		Bean beanForInserting = new Bean(LocalTime.of(0, 0), LocalTime.of(1, 30));
		
		LocalTime currentTime = LocalTime.of(9, 0);
		
		List<LocalTime> availableTimePoints = new ArrayList<LocalTime>();
		List<Bean> settedMovies = new ArrayList<Demo.Bean>();
		settedMovies.add(b1);
		settedMovies.add(b2);
		while (currentTime.compareTo(endTime) <= 0) {
			LocalTime tempDurationFromCurrentTime = currentTime
					.plusMinutes(cleaningTime.getMinute())
					.plusHours(beanForInserting.duration.getHour())
					.plusMinutes(beanForInserting.duration.getMinute());
			
			if (!settedMovies.isEmpty()) {
				Bean temp = settedMovies.get(0);
				if (tempDurationFromCurrentTime.compareTo(temp.startTime) <= 0) {
					availableTimePoints.add(currentTime);
				} else if (currentTime.compareTo(temp.startTime.plusMinutes(temp.duration.getMinute()).plusHours(temp.duration.getHour()).plusMinutes(cleaningTime.getMinute())) >= 0) {
					settedMovies.remove(0);
					availableTimePoints.add(currentTime);
				}
			} else {
				availableTimePoints.add(currentTime);
			}
			
			currentTime = currentTime.plusMinutes(cleaningTime.getMinute());
		}
		
		showList(availableTimePoints);
	}
	
	public static class Bean {
		LocalTime startTime;
		LocalTime duration;
		public Bean(LocalTime startTime, LocalTime duration) {
			this.duration = duration;
			this.startTime = startTime;
		}
	}
	private static void showList(List<LocalTime> list) {
		for(LocalTime s : list) {
			System.out.println(s.toString());
		}
	}
}
