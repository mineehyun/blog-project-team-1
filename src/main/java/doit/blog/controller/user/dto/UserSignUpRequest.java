package doit.blog.controller.user.dto;

import doit.blog.repository.user.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserSignUpRequest(
        @Schema(description = "아이디", example = "testId")
        String userLoginId,

        @Schema(description = "비밀번호", example = "testPassword")
        String userPassword,

        @Schema(description = "이름", example = "홍길동")
        String userName,

        @Schema(description = "닉네임", example = "각시탈")
        String userNickname,

        @Schema(description = "전화번호", example = "010-1234-5678")
        String userPhoneNumber
) {
        public User toEntity() {
                return new User(userLoginId,
                        userPassword,
                        userName,
                        userNickname,
                        userPhoneNumber);
        }
}
