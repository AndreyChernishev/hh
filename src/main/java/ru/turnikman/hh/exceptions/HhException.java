package ru.turnikman.hh.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HhException extends RuntimeException {
    String message;
}
