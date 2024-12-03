package doit.blog.controller.user;

import doit.blog.controller.user.dto.UserInfoResponse;
import doit.blog.controller.user.dto.UserLoginRequest;
import doit.blog.controller.user.dto.UserIdResponse;
import doit.blog.controller.user.dto.UserSignUpRequest;
import doit.blog.controller.user.exceptions.InvalidLoginIdException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "유저 관련 API")
interface UserControllerDocs {

    @Operation(summary = "아이디 중복 확인", description = "회원가입 시 아이디 중복을 확인한다.")
    @ApiResponse(responseCode = "200", description = "아이디 중복 확인 성공")
    @ApiResponse(responseCode = "400", description = "아이디 중복 확인 실패")
    ResponseEntity<String> checkDuplicateId(
            @Schema(description = "중복 확인할 아이디", example = "testId")
            String id
    );

    @Operation(summary = "회원가입", description = "회원가입을 한다.")
    @ApiResponse(responseCode = "200", description = "회원가입 성공")
    @ApiResponse(responseCode = "400", description = "회원가입 실패")
    void signUp(
            @Schema(description = "회원가입 정보", implementation = UserSignUpRequest.class)
            UserSignUpRequest userSignUpRequest
    );

    @Operation(summary = "로그인", description = "로그인을 한다.")
    @ApiResponse(responseCode = "200", description = "로그인 성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "로그인 실패")
    UserIdResponse login(
            @Schema(description = "로그인 정보", implementation = UserLoginRequest.class)
            UserLoginRequest userLoginRequest
    ) throws InvalidLoginIdException;

    @Operation(summary = "유저 정보 조회", description = "유저 정보를 조회한다.")
    @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "유저 정보 조회 실패")
    UserInfoResponse getUserInfo(
            @Schema(description = "유저 식별 ID", example = "1")
            Long userId
    );
}
