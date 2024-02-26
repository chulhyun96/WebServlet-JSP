package web_project.seveltjsp.jsp_PRJ.controller.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;

import java.io.IOException;

public class MyHandler implements MyAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Controller controller = (Controller) handler;
        return controller.service(request, response);
    }
}
