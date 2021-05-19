package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.bean.ScheduleItem;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlScheduleSessionDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;


public class ScheduleСommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		System.out.println("ScheduleСommand execute method");
		String inputDateString = request.getParameter("date");
		//validate inputDate
		LocalDate inputDate = LocalDate.parse(inputDateString);
		LocalDateTime searchingDate = null;
		if (inputDate.compareTo(LocalDate.now()) < 0) {
			System.out.println("Wrong param");
			//handle exception
		} else if (inputDate.compareTo(LocalDate.now()) == 0) {
			searchingDate = LocalDateTime.now();
		} else  {
			searchingDate = LocalDateTime.of(inputDate, LocalTime.MIN);
		}	
		
		LocalDateTime beginningOfNextDay = searchingDate.plusDays(1).toLocalDate().atStartOfDay();
		System.out.println("Prepare for load schedule from db");
		List<ScheduleItem> scheduleItems = new MysqlScheduleSessionDaoImpl().findScheduleItemsByScope(
				searchingDate, beginningOfNextDay);
		System.out.println("Schedule loaded");
		System.out.println(scheduleItems);
		request.setAttribute("scheduleItems", scheduleItems);
		System.out.println("Set request attribute");
		System.out.println("redirecting...");
		return Path.PAGE_SCHEDULE;
	}

}
