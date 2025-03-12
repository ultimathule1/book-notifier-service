package dev.sorokin.event.notificator.api.dto;

public record User(
        Long id,
        String login,
        int age,
        UserRole role
) {
}
