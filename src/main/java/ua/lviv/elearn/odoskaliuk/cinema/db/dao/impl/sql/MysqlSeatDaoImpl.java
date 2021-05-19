package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.SeatDao;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Seat;


public class MysqlSeatDaoImpl implements SeatDao {

	@Override
	public boolean create(Seat seat) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Seat findSeatById(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public List<Seat> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Seat update(Seat seat) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(Seat seat) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
