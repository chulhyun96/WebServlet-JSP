package web_project.seveltjsp.jsp_PRJ.model.VO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostVO {
    private String subject;
    private String content;
    private String userId;
    private int available;

    private PostVO(String subject, String content, String userId) {
        this.subject = subject;
        this.content = content;
        this.userId = userId;
    }

    //글 작성
    public static PostVO createPost(String subject, String content,String userId) {
        return new PostVO(subject, content, userId);
    }
}
