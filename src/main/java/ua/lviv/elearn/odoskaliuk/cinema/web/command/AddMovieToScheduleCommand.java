package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class AddMovieToScheduleCommand extends Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		System.out.println(request.getParameter("id"));
		return Path.PAGE_ADD_MOVIE_TO_SCHEDULE;
	}

}
