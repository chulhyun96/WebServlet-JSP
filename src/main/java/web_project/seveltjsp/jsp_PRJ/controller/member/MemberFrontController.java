package web_project.seveltjsp.jsp_PRJ.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.controller.ViewForwarder;
import web_project.seveltjsp.jsp_PRJ.controller.member.add.MemberAddController;
import web_project.seveltjsp.jsp_PRJ.controller.member.add.MemberAddFormController;
import web_project.seveltjsp.jsp_PRJ.controller.member.login.MemberLoginController;
import web_project.seveltjsp.jsp_PRJ.controller.member.login.MemberLogoutController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/member/*")
public class MemberFrontController extends HttpServlet {
    private Map<String, Controller> mappingController = new HashMap<>();

    public MemberFrontController() {
        mappingController.put("/member/addForm", new MemberAddFormController());
        mappingController.put("/member/add", new MemberAddController());
        mappingController.put("/member/login", new MemberLoginController());
        mappingController.put("/member/logout", new MemberLogoutController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Controller controller = mappingController.get(requestURI);

        ModelView mv = controller.service(request, response);
        ViewForwarder viewForwarder = viewResolver(mv.getViewName());
        viewForwarder.render(request, response);
    }

    private ViewForwarder viewResolver(String viewName) {
        return new ViewForwarder("/WEB-INF/member/" + viewName + ".jsp");
    }
}
