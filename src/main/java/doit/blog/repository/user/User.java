package doit.blog.repository.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name="member")
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userLoginId;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userPhoneNumber;

    public User(String userLoginId, String userPassword, String userName, String userNickname, String userPhoneNumber) {
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPhoneNumber = userPhoneNumber;
    }
}
