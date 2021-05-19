package ua.lviv.elearn.odoskaliuk.cinema.db.dao;

import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.entity.Movie;


public interface MovieDao {
	boolean create(Movie movie) throws DaoException;
	
	Movie findMovieById(int id) throws DaoException;
	List<Movie> findAll() throws DaoException;
	Movie findMovieByName(String name) throws DaoException;
	
	Movie update(Movie movie) throws DaoException;
	
	boolean delete(int id) throws DaoException;
	boolean delete(Movie movie) throws DaoException;
}
