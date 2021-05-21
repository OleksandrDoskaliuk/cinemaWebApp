package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class GotoRemoveMovieFromScheduleCommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		request.setAttribute("str", "Hello form servlet");
		return Path.PAGE_REMOVE_MOVIE_FROM_SCHEDULE;
	}
	

}
