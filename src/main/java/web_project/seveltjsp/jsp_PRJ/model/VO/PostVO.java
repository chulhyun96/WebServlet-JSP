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
    private LocalDateTime updatedDate;
    private String formattedDate;
    private int tableId;
    private int available;
    public PostVO() {
    }
    private PostVO(String subject, String content, String userId) {
        this.subject = subject;
        this.content = content;
        this.userId = userId;
    }
    private PostVO(int tableId, String subject, String content) {
        this.tableId = tableId;
        this.subject = subject;
        this.content = content;
    }
    //하나의 게시글
    public PostVO(int tableId, String subject, String content, String userId, LocalDateTime createdDate) {
        this.tableId = tableId;
        this.subject = subject;
        this.content = content;
        this.userId = getMaskedName(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        this.createdDate = createdDate;
        this.formattedDate = createdDate.format(formatter);
    }
    //글 작성
    public static PostVO createPost(String subject, String content,String userId) {
        return new PostVO(subject, content, userId);
    }
    //글 수정
    public static PostVO updatePost(int tableId, String subject, String content) {
        return new PostVO(tableId, subject, content);
    }

    private String getMaskedName(String userId) {
        if (userId.equals("관리자")) {
            return userId;
        }
        String stars = "**".repeat(userId.length() - 1);
        return userId.charAt(0) + stars;
    }
}
