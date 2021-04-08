package me.moon.boilerplate.service;

import lombok.RequiredArgsConstructor;
import me.moon.boilerplate.dto.user.UserResponseDto;
import me.moon.boilerplate.dto.user.UserSaveRequestDto;
import me.moon.boilerplate.dto.user.UserUpdateRequestDto;
import me.moon.boilerplate.entity.user.User;
import me.moon.boilerplate.entity.user.UserRepository;
import me.moon.boilerplate.utils.PasswordEncryptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponseDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(user->new UserResponseDto(user))
                .collect(Collectors.toList());
    }

    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return new UserResponseDto(user);
    }

    public void addUser(UserSaveRequestDto userSaveRequestDto) {
        validateExistEmail(userSaveRequestDto.getEmail());
        replaceEncryptedPassword(userSaveRequestDto);

        userRepository.save(userSaveRequestDto.toEntity());
    }

    private void replaceEncryptedPassword(UserSaveRequestDto userSaveRequestDto) {
        String encryptPassword = PasswordEncryptor.encrypt(userSaveRequestDto.getPassword());
        userSaveRequestDto.replaceEncryptPassword(encryptPassword);
    }

    private void validateExistEmail(String email) {
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("해당 이메일의 유저가 이미 존재합니다.");
        }
    }

    public void modifyUser(Long userId, UserUpdateRequestDto userUpdateRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        user.update(userUpdateRequestDto.getName(), userUpdateRequestDto.getPhone(), userUpdateRequestDto.getPicture());
    }
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        userRepository.delete(user);
    }


}
