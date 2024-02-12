package web_project.seveltjsp.jsp_PRJ.controller.member.add;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.model.service.MemberService;

import java.io.IOException;

@WebServlet("/member/add-form")
public class MemberAddFormController extends HttpServlet {
    private MemberService service;

    public MemberAddFormController() {
        this.service = new MemberService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/member/addForm.jsp";
        request.getRequestDispatcher(viewPath).forward(request,response);
    }
}
