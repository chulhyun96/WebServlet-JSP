package web_project.seveltjsp.jsp_PRJ.model.service;

import web_project.seveltjsp.jsp_PRJ.model.entity.Member;
import web_project.seveltjsp.jsp_PRJ.model.entity.Post;
import web_project.seveltjsp.jsp_PRJ.model.repository.PostDAO;

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
    /*public List<PostVO> findAll() {
        return rep.findAll();
    }*/
}
