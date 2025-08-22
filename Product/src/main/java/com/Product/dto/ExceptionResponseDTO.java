package com.Product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    public String apiPath;
    public HttpStatus statusCode;
    public String errorMessage;
    private LocalDateTime errorTime;
}
