package ru.chaplyginma.metricsconsumer.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;
import ru.chaplyginma.metricsconsumer.model.Metric;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MetricsMapperTests {
    private final MetricsMapper metricsMapper = Mappers.getMapper(MetricsMapper.class);

    @Test
    public void givenNullAddMetricDto_whenMapToMetric_thenReturnNull() {
        Metric metric = metricsMapper.addMetricDtoToMetric(null);

        assertThat(metric).isNull();
    }

    @Test
    public void givenAddMetricDto_whenMapToMetric_thenReturnMetric() {
        AddMetricDto addMetricDto = AddMetricDto.builder()
                .metricName("Some metric")
                .metricValue(0.0)
                .metricTimestamp(LocalDateTime.now())
                .build();

        Metric metric = metricsMapper.addMetricDtoToMetric(addMetricDto);

        assertThat(metric).isNotNull();
        assertThat(metric.getMetricName()).isEqualTo("Some metric");
        assertThat(metric.getMetricValue()).isEqualTo(addMetricDto.getMetricValue());
        assertThat(metric.getMetricTimestamp()).isEqualTo(addMetricDto.getMetricTimestamp());
    }

    @Test
    public void givenNullMetric_whenMapToResponseDto_thenReturnNull() {
        MetricResponseDto metricResponseDto = metricsMapper.metricToMetricResponseDto(null);

        assertThat(metricResponseDto).isNull();
    }

    @Test
    public void givenMetric_whenMapToResponseDto_thenReturnResponseDto() {
        Metric metric = new Metric(
                1L,
                "Some metric",
                0.0,
                LocalDateTime.now()
        );

        MetricResponseDto responseDto = metricsMapper.metricToMetricResponseDto(metric);

        assertThat(responseDto).isNotNull();
        assertThat(responseDto.getMetricName()).isEqualTo("Some metric");
        assertThat(responseDto.getMetricValue()).isEqualTo(metric.getMetricValue());
        assertThat(responseDto.getMetricTimestamp()).isEqualTo(metric.getMetricTimestamp());
    }
}
