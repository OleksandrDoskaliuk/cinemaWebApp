package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.elearn.odoskaliuk.cinema.db.dao.DaoException;
import ua.lviv.elearn.odoskaliuk.cinema.db.dao.MovieDao;
import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;
import ua.lviv.elearn.odoskaliuk.cinema.entity.Movie;


public class MysqlMovieDaoImpl implements MovieDao {

	@Override
	public boolean create(Movie movie) throws DaoException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean updated = false;
		try {
			con = DBManager.getInstance().getConnection();
			ps = con.prepareStatement(Constants.INSERT_MOVIE);
			int k = 1;
			ps.setString(k++, movie.getName());
			ps.setInt(k, movie.getDuration());
			if (ps.executeUpdate() > 0) {
				updated = true;
			}
		} catch (SQLException e) {
			DBManager.getInstance().rollbackAndClose(con);
			throw new DaoException(e);
		} finally {
			DBManager.getInstance().commitAndClose(con);
		}
		return updated;
	}

	@Override
	public Movie findMovieById(int id) throws DaoException {
		Movie movie = null;
		try (Connection con = DBManager.getInstance().getConnection(); 
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("Select * from movies where movies.movie_id = " + id + ";")) {
			if (rs.next()) {
				movie = new Movie();
				movie.setMovieId(rs.getInt("movie_id"));
				movie.setName(rs.getString("name"));
				movie.setDuration(rs.getInt("duration"));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return movie;
	}

	@Override
	public List<Movie> findAll() throws DaoException {
		List<Movie> movies = new ArrayList<Movie>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DBManager.getInstance().getConnection();
			st = con.createStatement();
			rs = st.executeQuery(Constants.FIND_ALL_FILMS);
			while (rs.next()) {
				int k = 1;
				Movie movie = new Movie();
				movie.setMovieId(rs.getInt(k++));
				movie.setName(rs.getString(k++));
				movie.setDuration(rs.getInt(k));
				movies.add(movie);
			}
		} catch (SQLException e) {
			DBManager.getInstance().rollbackAndClose(con);
			throw new DaoException(e);
		} finally {
			DBManager.getInstance().commitAndClose(con);
		}
		return movies;
	}

	@Override
	public Movie findMovieByName(String name) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public Movie update(Movie movie) throws DaoException {
		throw new DaoException("Unsuported operation");
	}

	@Override
	public boolean delete(int id) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Movie movie) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
