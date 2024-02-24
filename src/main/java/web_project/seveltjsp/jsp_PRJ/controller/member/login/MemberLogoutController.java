package web_project.seveltjsp.jsp_PRJ.controller.member.login;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;

import java.io.IOException;

public class MemberLogoutController implements Controller {
    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelView("../");
    }
}
