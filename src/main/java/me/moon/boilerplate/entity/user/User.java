package me.moon.boilerplate.entity.user;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.entity.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String phone;

    @NotNull
    private String picture;

    @Enumerated(EnumType.STRING)
    @NotNull
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

    public void update(String name, String phone, String picture){
        this.name=name;
        this.phone=phone;
        this.picture=picture;
    }

}
