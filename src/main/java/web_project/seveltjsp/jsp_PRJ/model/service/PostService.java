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

    public PostVO findPostByTableId(String tableId) {
        return rep.findPostByTableId(tableId);
    }
    //내가 쓴글 모두 조회
    public PostVO findPostByUserId(String userId) {
        return rep.findPostByUserId(userId);
    }

    public boolean checkIfEquals(String userId, String postVoId) {
        if (userId.equals(postVoId)) {
            return true;
        }
        return false;
    }

    public int update(PostVO postVO) {
        Post updatePost = new Post(postVO.getSubject(), postVO.getContent(),postVO.getTableId());
        return rep.update(updatePost);
    }
}
