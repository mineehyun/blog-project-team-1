package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.controller.user.exceptions.InvalidLoginIdException;
import doit.blog.repository.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import doit.blog.service.user.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDocs {
    private final UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<String> checkDuplicateId(@RequestParam String id) {
        if(userService.checkDuplicateId(id)){
            return ResponseEntity.status(409).body("이미 존재하는 아이디입니다.");
        }
        if (userService.checkValidFormat(id))
        {
            return ResponseEntity.status(409).body("유효하지 않은 아이디 형식입니다. 영문자와 숫자만 사용해 주세요.");
        }
        else {
            return ResponseEntity.status(200).body("사용할 수 있는 아이디입니다.");
        }
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        userService.save(userSignUpRequest.toEntity());
    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) throws InvalidLoginIdException {
        List<User> findUsers = userService.findByUserLoginId(userLoginRequest.userLoginId());

        if (findUsers.isEmpty())
        {
            throw new InvalidLoginIdException("존재하지 않는 사용자입니다.");
        }
        else {
            ResponseEntity.status(200).body(findUsers.get(0).getUserId());
            return new UserIdResponse(findUsers.get(0).getUserId());
        }
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable Long userId) {
        return null;
    }
}
