import java.sql.Connection;

import ua.lviv.elearn.odoskaliuk.cinema.db.util.DBManager;

public class Demo {
	public static void main(String[] args) {
		try(Connection con = DBManager.getInstance().getConnectionWithDriverManager()) {
			System.out.println(con);
			System.out.println("Connected!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
