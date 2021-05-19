package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.RoleDao;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Role;



public class MysqlRoleDaoImpl implements RoleDao{

	@Override
	public boolean create(Role role) throws DaoException {
		try (Connection con = DBManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(Constants.INSERT_ROLE, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, role.getRoleName());
			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					role.setRoleId(rs.getInt(1));
				}
				try {
					if (rs != null) {
						rs.close();
					} 
				} catch (SQLException e) {
					throw new DaoException(e);
				}
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public Role findRoleById(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public List<Role> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Role findRoleByName(String name) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Role update(Role role) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(Role role) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
