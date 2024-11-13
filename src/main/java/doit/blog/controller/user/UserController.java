package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.repository.user.UserRepository;
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

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDocs {
    private final UserService userService;

    @PostMapping("/validate")
    public ResponseEntity<String> checkDuplicateId(@RequestParam String id) {
        if(userService.checkDuplicateId(id)){
            System.out.println("duplicate");
            return ResponseEntity.status(400).body("이미 존재하는 아이디입니다.");
        }
        else {
            System.out.println("success");
            return ResponseEntity.status(200).body("사용할 수 있는 아이디입니다.");
        }
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        userService.save(userSignUpRequest.toEntity());
        System.out.println(userService.findByUserLoginId(userSignUpRequest.userLoginId()).get(0).getUserName());
    }

    @PostMapping("/login")
    public UserIdResponse login(@RequestBody UserLoginRequest userLoginRequest) {
        return null;
    }

    @GetMapping("/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable Long userId) {
        return null;
    }
}
