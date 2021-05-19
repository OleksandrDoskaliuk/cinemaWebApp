package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.SeatCategoryDao;
import ua.lviv.elearn.odoskaliuk.cinema.entity.SeatCategory;


public class MysqlSeatCategoryDaoImpl implements SeatCategoryDao {

	@Override
	public boolean create(SeatCategory seatCategory) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public SeatCategory findSeatCategoryById(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public SeatCategory findSeatCategoryByName(String name) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public List<SeatCategory> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public SeatCategory update(SeatCategory seatCategory) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(SeatCategory seatCategory) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
