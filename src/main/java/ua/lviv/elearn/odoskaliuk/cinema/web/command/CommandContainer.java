package ua.lviv.elearn.odoskaliuk.cinema.web.command;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		commands.put("schedule", new ScheduleСommand());
		commands.put("adminPage", new GotoAdminPageCommand());
		commands.put("adminCommand", new AdminPageCommand());
		commands.put("showAllMovies", new ShowAllMoviesCommand());
		commands.put("addMovieToSchedule", new AddMovieToScheduleCommand());
		commands.put("gotoAddMovieToSchedule", new GotoAddMovieToScheduleCommand());
		commands.put("createNewMovie", new CreateNewMovieCommand());
			
		/*
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("noCommand", new NoCommand());
		commands.put("viewSettings", new ViewSettingsCommand());
		commands.put("updateSettings", new UpdateSettingsCommand());
		
		// client commands
		commands.put("listMenu", new ListMenuCommand());
		
		// admin commands
		commands.put("listOrders", new ListOrdersCommand());
		*/
	}

	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand"); 
		}
		return commands.get(commandName);
	}
}
