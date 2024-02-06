package web_project.seveltjsp.jsp_PRJ.service;

import web_project.seveltjsp.jsp_PRJ.entity.Post;
import web_project.seveltjsp.jsp_PRJ.repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() throws ClassNotFoundException {
        this.postRepository = new PostRepository();
    }
    public List<Post> getList() {
        return postRepository.getPostList();
    }
}
