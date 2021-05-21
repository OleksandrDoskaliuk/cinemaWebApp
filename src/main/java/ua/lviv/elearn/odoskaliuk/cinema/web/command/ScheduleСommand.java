package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.bean.ScheduleItemBean;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlScheduleSessionDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.web.FilteringOption;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;
import ua.lviv.elearn.odoskaliuk.cinema.web.SortingOption;


public class ScheduleСommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		List<ScheduleItemBean> scheduleItemBeans = new ArrayList<ScheduleItemBean>();
		
		String requestSortingOption = request.getParameter("sorting");
		String requestFilterringOption = request.getParameter("filtering");
		String requestDateOption = request.getParameter("date");
		
		SortingOption sortingOption = requestSortingOption != null ? SortingOption.valueOf(requestSortingOption) : SortingOption.BY_DATE;
		FilteringOption filterringOption = requestFilterringOption != null ? FilteringOption.valueOf(requestFilterringOption) : FilteringOption.AVAILABLE;
		LocalDate dateOption = requestDateOption != null ? LocalDate.parse(requestDateOption) : LocalDate.now();
		
		LocalDateTime fromDate = LocalDateTime.of(dateOption, LocalTime.MIN);
		LocalDateTime toDate = fromDate.plusDays(1);
		
		scheduleItemBeans = new MysqlScheduleSessionDaoImpl().findScheduleItemsByScope(fromDate, toDate);
		sortItemBeans(scheduleItemBeans, sortingOption);
		scheduleItemBeans = filterItemBeans(scheduleItemBeans, filterringOption);
		
		request.setAttribute("scheduleItems", scheduleItemBeans);
		request.setAttribute("dateItems", getSevenDaysFromCurrentDay());
		return Path.PAGE_SCHEDULE;
	}
	
	private void sortItemBeans(List<ScheduleItemBean> list, SortingOption option) {
		switch (option) {
		case BY_DATE:
			Collections.sort(list, (b1, b2) -> LocalTime.parse(b1.getMovieStartTime()).compareTo(LocalTime.parse(b2.getMovieStartTime())));
			break;
		case BY_NAME:
			Collections.sort(list, (b1, b2) -> b1.getMovieName().compareTo(b2.getMovieName()));
			break;
		default:
			break;
		}
	}
	
	private List<ScheduleItemBean> filterItemBeans(List<ScheduleItemBean> list, FilteringOption option) {
		List<ScheduleItemBean> result = new ArrayList<ScheduleItemBean>();
		switch (option) {
		case AVAILABLE:
			result = list.stream()
			.filter(item -> LocalTime.parse(item.getMovieStartTime()).compareTo(LocalTime.now())  > 0)
			.collect(Collectors.toList());
			break;
		default:
			return list;
		}
		return result;
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
