package web_project.seveltjsp.jsp_PRJ.model.service;

import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;

import java.util.List;

public class PostService {
    private PostDAO rep;

    public PostService() {
        this.rep = new PostService();
    }
    public List<PostVO> findAll() {
        return rep.findAll();
    }
}
