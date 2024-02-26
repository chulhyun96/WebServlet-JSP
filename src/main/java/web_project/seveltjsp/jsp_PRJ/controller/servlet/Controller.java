package web_project.seveltjsp.jsp_PRJ.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Controller {
    ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
