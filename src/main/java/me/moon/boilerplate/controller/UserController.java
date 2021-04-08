package me.moon.boilerplate.controller;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.dto.user.UserResponseDto;
import me.moon.boilerplate.dto.user.UserSaveRequestDto;
import me.moon.boilerplate.dto.user.UserUpdateRequestDto;
import me.moon.boilerplate.service.UserService;
import me.moon.boilerplate.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    //회원 리스트 조회
    @GetMapping()
    public List<UserResponseDto> getUserList(){
        return userService.getUserList();
    }

    //회원조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId) {
        UserResponseDto user = userService.getUser(userId);
        return new ResponseEntity<UserResponseDto>(user, HttpStatus.OK);
    }

    //회원가입
    @PostMapping()
    public ResponseEntity register(@RequestBody UserSaveRequestDto userSaveRequestDto){
        userService.addUser(userSaveRequestDto);
        return new ResponseEntity(new Message("회원가입 성공!"), HttpStatus.CREATED);
    }

    //회원수정
    @PutMapping("/{userId}")
    public ResponseEntity modifyUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        userService.modifyUser(userId, userUpdateRequestDto);
        return new ResponseEntity(new Message("수정을 완료했습니다."), HttpStatus.OK);
    }

    //회원탈퇴
    @DeleteMapping("/{userId}")
    public ResponseEntity withdrawal(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(new Message("회원탈퇴를 완료했습니다."), HttpStatus.OK);
    }
}
