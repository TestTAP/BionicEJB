<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets">

    <body>

        <ui:composition template="./WEB-INF/template.xhtml">

            <ui:define name="content">
                Showing #{movieFacadeREST.countREST()} movies in #{theaterFacadeREST.countREST()} theaters!
            </ui:define>

        </ui:composition>

    </body>
</html>













































<%-- 
    Document   : login
    Created on : 21.02.2013, 21:16:54
    Author     : Artem
--%>

<!--  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login</h3>
        <hr/>
        <form name="loginForm" method="POST" action="ControllerEJB">
            <input type="hidden" name="command" value ="login"/>
            Login:<br/>
            <input type="text" name="login" value =""> <br/>
            Password:<br/>
            <input type="password" name ="password" value="">
            <br/>
            <input type ="submit" value="Enter">
        </form>
        <hr/>
    </body>
</html>
 -->
