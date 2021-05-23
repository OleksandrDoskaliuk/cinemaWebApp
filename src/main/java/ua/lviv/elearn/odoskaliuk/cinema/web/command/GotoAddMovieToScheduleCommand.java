package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.bean.DurationSessionBean;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlMovieDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlScheduleSessionDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Movie;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class GotoAddMovieToScheduleCommand extends Command{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		if (request.getParameter("commit") == null) {
			LocalTime start = LocalTime.of(9, 0);
			LocalTime end = LocalTime.of(22, 0);
			LocalTime timeout = LocalTime.of(0, 15);
			int movieId = Integer.valueOf(request.getParameter("movieId"));
			String currentDate = request.getParameter("date");
			if (currentDate == null) {
				currentDate = LocalDate.now().toString();
			}
			if (LocalDate.parse(currentDate).compareTo(LocalDate.now()) == 0) {
				while (start.compareTo(LocalTime.now()) <= 0) {
					start = start.plusMinutes(timeout.getMinute());
				}
			}
			List<String> dates = getSevenDaysFromCurrentDay();
			Movie movie = new MysqlMovieDaoImpl().findMovieById(movieId);
			LocalDateTime fromDate = LocalDateTime.of(LocalDate.parse(currentDate), LocalTime.MIN);
			LocalDateTime toDate = LocalDateTime.of(LocalDate.parse(currentDate).plusDays(1), LocalTime.MIN);
					
			List<DurationSessionBean> settedTimePoints = new MysqlScheduleSessionDaoImpl().findDurationStartTimeByScope(fromDate, toDate);

			System.out.println(settedTimePoints);
			List<String> timePoints = getAvailableTimePoints(start, end, timeout, movie.getDuration(), settedTimePoints);
			System.out.println(timePoints);
			request.setAttribute("dateItems", dates);
			request.setAttribute("timePoints", timePoints);
			request.setAttribute("movie", movie);
			return Path.PAGE_ADD_MOVIE_TO_SCHEDULE;
		}
		return new AddMovieToScheduleCommand().execute(request, response);
	}
	
	private List<String> getAvailableTimePoints(LocalTime start, LocalTime end, LocalTime timeout, int movieDuration, List<DurationSessionBean> settedTimePoints) {
		List<LocalTime> availableTimePoints = new ArrayList<LocalTime>();
		while (start.compareTo(end) <= 0) {
			LocalTime tempDurationFromCurrentTime = start
					.plusMinutes(timeout.getMinute())
					.plusSeconds(movieDuration);
			
			if (!settedTimePoints.isEmpty()) {
				DurationSessionBean temp = settedTimePoints.get(0);
				if (tempDurationFromCurrentTime.compareTo(temp.getStartTime()) <= 0) {
					availableTimePoints.add(start);
				} else if (start.compareTo(temp.getStartTime().plusSeconds(temp.getDuration()).plusMinutes(timeout.getMinute())) >= 0) {
					settedTimePoints.remove(0);
					continue;
				}
			} else {
				availableTimePoints.add(start);
			}
			
			start = start.plusMinutes(timeout.getMinute());
		}
		
		return availableTimePoints.stream().map(e -> e.format(DateTimeFormatter.ofPattern("HH:mm"))).collect(Collectors.toList());
	}
	
	private List<String> getSevenDaysFromCurrentDay() {
		List<String> days = new ArrayList<String>();
		LocalDate currentDay = null;
		for (int i = 0; i < 7; i++) {
			if (currentDay == null) {
				currentDay = LocalDate.now();
			} else {
				currentDay = currentDay.plusDays(1);
			}
			days.add(currentDay.toString());
		}
		return days;
	}
}
