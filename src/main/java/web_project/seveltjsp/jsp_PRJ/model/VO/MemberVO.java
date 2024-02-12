package web_project.seveltjsp.jsp_PRJ.model.VO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private String userId;
    private String userName;
    private String userPassword;


    //회원가입용
    private MemberVO(String userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    //로그인용
    private MemberVO(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public static MemberVO login(String userID, String userPassword) {
        return new MemberVO(userID, userPassword);
    }
}
