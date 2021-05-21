package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlMovieDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.TimeDurationFormatter;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Movie;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class CreateNewMovieCommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		String name = request.getParameter("name");
		String duration = request.getParameter("duration");
		Movie movie = new Movie();
		movie.setName(name);
		movie.setDuration(TimeDurationFormatter.getDurationFromString(duration));
		new MysqlMovieDaoImpl().create(movie);
		return Path.PAGE_ADMIN;
	}

}
