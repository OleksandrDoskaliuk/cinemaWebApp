package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.bean.ScheduleItemBean;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.ScheduleSessionDao;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.MysqlDateFormatter;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.TimeDurationFormatter;
import ua.lviv.elearn.odoskaliuk.cinema.entity.ScheduleSession;


public class MysqlScheduleSessionDaoImpl implements ScheduleSessionDao {

	public List<ScheduleItemBean> findScheduleItemsByScope(LocalDateTime fromDate, LocalDateTime toDate) throws DaoException {
		List<ScheduleItemBean> scheduleItemBeans = new ArrayList<ScheduleItemBean>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBManager.getInstance().getConnection();
			ps = con.prepareStatement(Constants.FIND_SCHEDULE_BY_DATE_SCOPE);
			int k = 1;
			ps.setString(k++, MysqlDateFormatter.getStringFromLocalDateTime(fromDate));
			ps.setString(k++, MysqlDateFormatter.getStringFromLocalDateTime(toDate));
			rs = ps.executeQuery();
			while (rs.next()) {
				k = 1;
				ScheduleItemBean bean = new ScheduleItemBean();
				bean.setSessionId(rs.getInt(k++));
				bean.setMovieName(rs.getString(k++));
				bean.setMovieDuration(TimeDurationFormatter.getStringFromTimeDuration(rs.getInt(k++)));
				LocalDateTime movieStartTime = MysqlDateFormatter.getLocalDateTimeFromString(rs.getString(k));
				bean.setMovieStartTime(MysqlDateFormatter.getStringTimeFromLocalDateTime(movieStartTime));
				scheduleItemBeans.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DBManager.getInstance().rollbackAndClose(con);
			throw new DaoException(e);
		} finally {
			DBManager.getInstance().commitAndClose(con);
		}
		return scheduleItemBeans;
	}

	@Override
	public boolean create(ScheduleSession scheduleSession) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public ScheduleSession findSessionById(int id) throws DaoException {
		ScheduleSession session = null;
		try (Connection con = DBManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(Constants.FIND_SESSION_BY_ID)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			try {
				if (rs.next()) {
					int k = 1;
					session = new ScheduleSession();
					session.setSessionId(rs.getInt(k++));
					session.setMovieId(rs.getInt(k++));
					session.setCinemaHallId(rs.getInt(k++));
					session.setStartTime(MysqlDateFormatter.getLocalDateTimeFromString(rs.getString(k++)));
				}
				if (rs != null) {
					rs.close();
				} 
			} catch (SQLException e) {
				throw e;
				}
			} catch (SQLException e) {
				throw new DaoException(e);
				}
		return session;
	}


	@Override
	public List<ScheduleSession> findAll() throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public ScheduleSession update(ScheduleSession scheduleSession) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(ScheduleSession scheduleSession) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

}
