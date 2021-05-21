package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.web.Path;

public class AdminPageCommand extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
		return Path.PAGE_ADMIN;
	}
	
}
