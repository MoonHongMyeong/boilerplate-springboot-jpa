package me.moon.boilerplate.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.entity.user.Role;
import me.moon.boilerplate.entity.user.User;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String picture;

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phone(phone)
                .picture(picture)
                .role(Role.USER)
                .build();
    }

    public void replaceEncryptPassword(String encryptPassword){
        this.password=encryptPassword;
    }
}
