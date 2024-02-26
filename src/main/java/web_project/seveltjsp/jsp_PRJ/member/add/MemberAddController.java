package web_project.seveltjsp.jsp_PRJ.member.add;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.servlet.ModelView;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.service.MemberService;

import java.io.IOException;

public class MemberAddController implements Controller {
    private MemberService service;

    public MemberAddController() {
        this.service = new MemberService();
    }

    @Override
    public ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String name = request.getParameter("userName");


        MemberVO memberVO = MemberVO.createMember(userID, userPassword, name);
        service.addMember(memberVO);

        request.setAttribute("member", memberVO);
        return new ModelView("signIn");
    }
}
