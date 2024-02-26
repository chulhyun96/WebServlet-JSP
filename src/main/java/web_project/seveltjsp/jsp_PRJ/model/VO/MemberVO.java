package web_project.seveltjsp.jsp_PRJ.front_controller.model.VO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
    private String userId;
    private String userName;
    private String userPassword;
    private String message;


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

    public MemberVO(String message) {
        this.message = message;
    }

    public static MemberVO login(String userID, String userPassword) {
        return new MemberVO(userID, userPassword);
    }

    public static MemberVO createMember(String userID, String userPassword, String userName) {
         if (validateNull(userID, userPassword, userName)) {
             return new MemberVO(userID, userPassword, userName);
         }
         return new MemberVO("입력하지 않은 사항이 존재합니다");
    }
    private static boolean validateNull(String userID, String userPassword, String userName) {
        return !userID.isBlank() && !userPassword.isBlank() && !userName.isBlank();
    }
}
