package ua.lviv.elearn.odoskaliuk.cinema.db.dao.impl.sql;

public class Constants {
	public static final String ROLE_ID = "role_id";
	public static final String ROLE_NAME = "role_name";
	private static final String SESSION_ID = "session_id";
	private static final String SESSION_MOVIE_ID = "movie_id";
	private static final String SESSION_CINEMA_HALL_ID = "cinema_hall_id";
	private static final String SESSION_START_TIME = "start_time";
	public static final String USER_ID = "user_id";
	public static final String USER_FIRSTNAME = "firstname";
	public static final String USER_LASTNAME = "lastname";
	public static final String USER_LOGIN = "login";
	public static final String USER_PASSWORD = "password";
	public static final String USER_ROLE_ID = "role_id";
	public static final String INSERT_ROLE = "INSERT INTO roles(`role_name`) VALUES (?)";
	public static final String FIND_SCHEDULE_BY_DATE_SCOPE = "select m.name, m.duration, s.start_time, (select count(*) from tickets where s.session_id = tickets.session_id) as seats_reserved"
			+ "	from sessions as s inner join movies as m on s.movie_id = m.movie_id and s.start_time > ? and s.start_time < ?;";
	
	public static final String FIND_SESSION_BY_ID = "select * from sessions where sessions.session_id = ?";
	public static final String INSERT_USER = "INSERT INTO users(`firstname`, `lastname`, `login`, `password`, `role_id`) VALUES(?, ?, ?, ?, ?);";
	public static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id = (?);";
	public static final String FIND_ALL_USERS = "SELECT * FROM users;";
	public static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login = (?);";
	public static final String UPDATE_USER = "UPDATE users SET firstname = ?, lastname = ?, login = ?, password = ?, role_id = ? WHERE user_id = ?;";
	public static final String DELETE_USER_BY_ID = "DELETE FROM users where user_id = ?;";
	public static final String DELETE_USER_BY_PARAMS = "DELETE FROM users where firstname = ? and lastname = ? and login = ?;";
}
