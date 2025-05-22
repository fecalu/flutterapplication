package io.github.fecalu.backend.dto;

import java.time.Instant;

public record ErroDTO(

        Instant timestamp,
        Integer status,
        String error,
        String path

) {
}
