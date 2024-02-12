package web_project.seveltjsp.jsp_PRJ.model.VO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostVO {
    private String subject;
    private String content;
    private String userId;

    public PostVO(String subject, String content, String userId) {
        this.subject = subject;
        this.content = content;
        this.userId = userId;
    }
}
