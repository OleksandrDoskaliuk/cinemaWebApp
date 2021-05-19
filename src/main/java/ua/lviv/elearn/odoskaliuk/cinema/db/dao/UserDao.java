package ua.lviv.elearn.odoskaliuk.cinema.db.dao;

import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.entity.User;


public interface UserDao {
	boolean create(User user) throws DaoException;
	
	User findUserById(int id) throws DaoException;
	List<User> findAll() throws DaoException;
	User findUserByLogin(String login) throws DaoException;
	
	boolean update(User user) throws DaoException;
	
	boolean delete(int id) throws DaoException;
	boolean delete(User user) throws DaoException;
}
