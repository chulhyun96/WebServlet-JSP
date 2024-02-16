package web_project.seveltjsp.jsp_PRJ.model.service;

import web_project.seveltjsp.jsp_PRJ.model.VO.PostVO;
import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.entity.Post;
import web_project.seveltjsp.jsp_PRJ.model.repository.PostDAO;

import java.util.List;

public class PostService {
    private PostDAO rep;

    public PostService() {
        this.rep = new PostDAO();
    }

    public int submitPost(String subject, String content, Member member) {
        Post post = new Post(subject,content,member);
        return rep.submitPost(post);
    }

    public Member findByUserId(String userId) {
        return rep.findByUserId(userId);
    }

    public List<PostVO> findAll(int pageNumber) {
        return rep.findAll(pageNumber);
    }

    public int getTotalPages() {
        return rep.countPage();
    }

    public PostVO getPost(String tableId) {
        return rep.getPost(tableId);
    }

    public PostVO findPostByUserId(String userId) {
        return rep.findPostByUserId(userId);
    }
}
