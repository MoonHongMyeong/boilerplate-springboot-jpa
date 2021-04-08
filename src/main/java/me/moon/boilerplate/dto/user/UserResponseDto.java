package me.moon.boilerplate.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.entity.user.Role;
import me.moon.boilerplate.entity.user.User;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String picture;
    private Role role;

    public UserResponseDto (User entity) {
        this.id=entity.getId();
        this.name=entity.getName();
        this.email=entity.getEmail();
        this.phone=entity.getPhone();
        this.picture=entity.getPicture();
        this.role=entity.getRole();
    }
}
