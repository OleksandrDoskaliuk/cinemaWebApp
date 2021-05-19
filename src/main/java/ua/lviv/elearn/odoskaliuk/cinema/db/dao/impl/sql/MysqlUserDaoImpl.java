package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.UserDao;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;
import ua.lviv.elearn.odoskaliuk.cinema.entity.User;


public class MysqlUserDaoImpl implements UserDao{

	@Override
	public boolean create(User user) throws DaoException {
		try (Connection connection = DBManager.getInstance().getConnection();
				PreparedStatement ps = connection.prepareStatement(Constants.INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
			int k = 1;
			ps.setString(k++, user.getFirstname());
			ps.setString(k++, user.getLastname());
			ps.setString(k++, user.getLogin());
			ps.setString(k++, user.getPassword());
			ps.setInt(k++, user.getRoleId());
			if (ps.executeUpdate() == 1) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					user.setUserId(rs.getInt(1));
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
	public User findUserById(int id) throws DaoException {
		User user = null;
		try (Connection connection = DBManager.getInstance().getConnection();
				PreparedStatement ps = connection.prepareStatement(Constants.FIND_USER_BY_ID)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = createUserFromResulSet(rs);
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DaoException(e);
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return user;
	}

	@Override
	public List<User> findAll() throws DaoException {
		List<User> userList = new ArrayList<User>();
		try (Connection con = DBManager.getInstance().getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(Constants.FIND_ALL_USERS)) {
			while (rs.next()) {
				User user = createUserFromResulSet(rs);
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException();
		}
		return userList;
	}

	
	@Override
	public User findUserByLogin(String login) throws DaoException {
		User user = null;
		try (Connection connection = DBManager.getInstance().getConnection();
				PreparedStatement ps = connection.prepareStatement(Constants.FIND_USER_BY_LOGIN)) {
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = createUserFromResulSet(rs);
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DaoException(e);
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return user;
	}

	@Override
	public boolean update(User user) throws DaoException {
		try (Connection con = DBManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(Constants.UPDATE_USER)) {
			int k = 1;
			ps.setString(k++, user.getFirstname());
			ps.setString(k++, user.getLastname());
			ps.setString(k++, user.getLogin());
			ps.setString(k++, user.getPassword());
			ps.setInt(k++, user.getRoleId());
			ps.setInt(k++, user.getUserId());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws DaoException {
		try (Connection con = DBManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(Constants.DELETE_USER_BY_ID)) {
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public boolean delete(User user) throws DaoException {
		try (Connection con = DBManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(Constants.DELETE_USER_BY_PARAMS)) {
			int k = 1;
			ps.setString(k++, user.getFirstname());
			ps.setString(k++, user.getLastname());
			ps.setString(k++, user.getLogin());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return false;
	}

	private User createUserFromResulSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt(Constants.USER_ID));
		user.setFirstname(rs.getString(Constants.USER_FIRSTNAME));
		user.setLastname(rs.getString(Constants.USER_LASTNAME));
		user.setLogin(rs.getString(Constants.USER_LOGIN));
		user.setPassword(rs.getString(Constants.USER_PASSWORD));
		user.setRoleId(rs.getInt(Constants.USER_ROLE_ID));
		return user;
	}
}
