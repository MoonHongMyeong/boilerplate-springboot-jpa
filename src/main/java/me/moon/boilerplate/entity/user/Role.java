package me.moon.boilerplate.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN("ADMIN","운영자"),
    USER("USER", "사용자");
    private final String key;
    private final String name;
}
