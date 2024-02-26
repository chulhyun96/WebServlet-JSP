package web_project.seveltjsp.jsp_PRJ.front_controller.model.service;

import web_project.seveltjsp.jsp_PRJ.front_controller.model.VO.MemberVO;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.front_controller.model.repository.MemberDAO;

public class MemberService {
    private MemberDAO rep;

    public MemberService() {
        this.rep = new MemberDAO();
    }
    public int login(String userID, String userPassword) {
        return rep.login(userID, userPassword);
    }

    public int addMember(MemberVO memberVO) {
        Member member = new Member(memberVO);
        return rep.addMember(member);
    }
}
