package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.TicketDao;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Ticket;


public class MysqlTicketDaoImpl implements TicketDao {

	@Override
	public boolean create(Ticket ticket) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Ticket findTicketById(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public List<Ticket> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Ticket update(Ticket ticket) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(Ticket ticket) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
