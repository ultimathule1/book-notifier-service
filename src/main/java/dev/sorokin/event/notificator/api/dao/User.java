package dev.sorokin.event.notificator.api.dao;

public record User(
        Long id,
        String login,
        int age,
        UserRole role
) {
}
