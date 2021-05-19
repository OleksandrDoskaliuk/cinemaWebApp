package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;


public abstract class Command implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException;
	
	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}
}
