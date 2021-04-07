package me.moon.boilerplate.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import me.moon.boilerplate.entity.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String phone;

    @NonNull
    private String picture;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

    @Builder
    public User(String name, String email, String password, String phone, String picture, Role role){
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.picture=picture;
        this.role=role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
