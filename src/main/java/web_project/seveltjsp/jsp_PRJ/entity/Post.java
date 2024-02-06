package web_project.seveltjsp.jsp_PRJ.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String createdAt;
    public Post() {
    }
    public Post(Long id, String title, String author, String content, String createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }
}