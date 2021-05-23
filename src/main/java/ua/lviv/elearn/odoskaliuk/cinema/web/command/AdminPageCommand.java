package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class AdminPageCommand extends Command {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		String showMovies = request.getParameter("showMovies");
		String showAttendance = request.getParameter("showAttendance");
		System.out.println("AdminPageCommand");
		if(showMovies != null && showAttendance != null) {
			throw new RuntimeException("Error");
		} else if (showMovies != null) {
			return new ShowAllMoviesCommand().execute(request, response);
		} else if (showAttendance != null) {
			return null;
		}
		return null;
	}

}
