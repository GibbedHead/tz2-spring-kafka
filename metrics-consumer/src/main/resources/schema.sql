CREATE TABLE metric
(
    id          BIGINT           NOT NULL GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    metric_name VARCHAR(255)     NOT NULL,
    value       DOUBLE PRECISION NOT NULL,
    timestamp   TIMESTAMP        NOT NULL
);