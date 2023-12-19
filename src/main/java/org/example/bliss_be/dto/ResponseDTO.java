package org.example.bliss_be.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor @Builder
public class ResponseDTO<T> {
    String message;
    T data;
}
