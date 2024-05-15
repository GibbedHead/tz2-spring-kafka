package ru.chaplyginma.metricsconsumer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricDto {
    @NotBlank
    String metricName;
    Double value;
    @NotNull
    LocalDateTime timestamp;
}