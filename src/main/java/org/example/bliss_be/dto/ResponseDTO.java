package org.example.bliss_be.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor @Builder
public class ResponseDTO<T> {
    String message;
    T data;
}
