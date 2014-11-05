package com.bionic.movieplex.logic.actions;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.bionic.movieplex.logic.actions.commands.LoginCommand;
import com.bionic.movieplex.logic.actions.commands.NoCommand;

public class ActionFactory {
	private static final String COMMAND_PARAMETER = "command";
	private static ActionFactory instance = null;
	HashMap<String, ActionCommand> commands = new HashMap<String, ActionCommand>();

	private ActionFactory() {
		// заполнение таблицы командами
		commands.put("login", new LoginCommand());
	}

	public ActionCommand getCommand(HttpServletRequest request) {
		// извлечение команды из запроса
		String action = request.getParameter(COMMAND_PARAMETER);
		// получение объекта, соответствующего команде
		ActionCommand command = commands.get(action);
		if (command == null) {
			// если команды не существует в текущем объекте
			command = new NoCommand();
		}
		return command;
	}

	// создание единственного объекта по шаблону Singleton
	public static synchronized ActionFactory getInstance() {
		if (instance == null) {
			instance = new ActionFactory();
		}
		return instance;
	}
}
