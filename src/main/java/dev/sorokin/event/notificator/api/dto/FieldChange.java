package dev.sorokin.event.notificator.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FieldChange<T> {
    private T oldValue;
    private T newValue;

//    private FieldChange(T oldValue, T newValue) {
//        this.oldValue = oldValue;
//        this.newValue = newValue;
//    }
//
//    public static <T> FieldChange<T> of(T oldValue, T newValue) {
//        return new FieldChange<>(oldValue, newValue);
//    }
}