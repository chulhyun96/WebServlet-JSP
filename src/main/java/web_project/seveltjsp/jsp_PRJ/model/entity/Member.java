package web_project.seveltjsp.jsp_PRJ.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Member", schema = "WEB")
public class Member {
    @Id
    @Column(name = "UserID", nullable = false, length = 20)
    private String userID;

    @Column(name = "UserPassword", nullable = false, length = 20)
    private String userPassword;

    @Column(name = "UserName", nullable = false, length = 20)
    private String userName;

}