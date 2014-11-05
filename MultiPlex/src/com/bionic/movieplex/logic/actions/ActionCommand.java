package com.bionic.movieplex.logic.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public interface ActionCommand {
      public String execute(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException;
}
