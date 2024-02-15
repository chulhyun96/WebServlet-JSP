package web_project.seveltjsp.jsp_PRJ.model.VO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class PostVO {
    private String subject;
    private String content;
    private String userId;
    private LocalDateTime createdDate;
    private String formattedDate;
    private LocalDateTime updatedDate;
    private int tableId;
    private int available;
    public PostVO() {
    }
    private PostVO(String subject, String content, String userId) {
        this.subject = subject;
        this.content = content;
        this.userId = userId;
    }

    //하나의 게시글
    public PostVO(int tableId, String subject, String content, String userId, LocalDateTime createdDate) {
        this.tableId = tableId;
        this.subject = subject;
        this.content = content;
        this.userId = getMaskedName(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMdd-HH:mm");
        this.createdDate = createdDate;
        this.formattedDate = createdDate.format(formatter);
    }

    private String getMaskedName(String userId) {
        if (userId.equals("관리자")) {
            return userId;
        }
        String stars = "**".repeat(userId.length() - 1);
        return userId.charAt(0) + stars;
    }
    //글 작성
    public static PostVO createPost(String subject, String content,String userId) {
        return new PostVO(subject, content, userId);
    }
}
