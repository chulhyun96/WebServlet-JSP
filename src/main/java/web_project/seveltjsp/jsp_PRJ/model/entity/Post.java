package web_project.seveltjsp.jsp_PRJ.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Post", schema = "WEB")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TableID", nullable = false)
    private Integer id;

    @Column(name = "Subject", nullable = false)
    private String subject;

    @Column(name = "Content", nullable = false, length = 2048)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserID", nullable = false)
    private Member member;

    @Column(name = "Created_Date")
    private Instant createdDate;

    @Column(name = "Update_Date")
    private Instant updateDate;

    @Column(name = "Available")
    private Integer available;
    public Post() {
    }
    public Post(String subject, String content, Member member) {
        this.subject = subject;
        this.content = content;
        this.member = member;
    }
}