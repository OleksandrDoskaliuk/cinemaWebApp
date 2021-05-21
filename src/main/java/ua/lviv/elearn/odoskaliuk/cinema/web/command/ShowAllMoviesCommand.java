package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql.MysqlMovieDaoImpl;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Movie;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class ShowAllMoviesCommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		List<Movie> movies = new ArrayList<Movie>();
		
		movies = new MysqlMovieDaoImpl().findAll();
		
		request.setAttribute("movies", movies);
		return Path.PAGE_ALL_MOVIES;
	}

}
