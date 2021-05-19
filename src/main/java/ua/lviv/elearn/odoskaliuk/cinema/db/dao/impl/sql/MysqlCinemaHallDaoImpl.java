package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.CinemaHallDao;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.entity.CinemaHall;


public class MysqlCinemaHallDaoImpl implements CinemaHallDao {

	@Override
	public boolean create(CinemaHall cinemaHall) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public CinemaHall findCinemaHallById(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public List<CinemaHall> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public CinemaHall update(CinemaHall cinemaHall) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(CinemaHall cinemaHall) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
