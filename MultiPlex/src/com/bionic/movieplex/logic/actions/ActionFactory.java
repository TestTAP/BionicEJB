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
		commands.put("login", new LoginCommand());
	}

	public ActionCommand getCommand(HttpServletRequest request) {
		String action = request.getParameter(COMMAND_PARAMETER);
		ActionCommand command = commands.get(action);
		if (command == null) {
			command = new NoCommand();
		}
		return command;
	}

	public static synchronized ActionFactory getInstance() {
		if (instance == null) {
			instance = new ActionFactory();
		}
		return instance;
	}
}
