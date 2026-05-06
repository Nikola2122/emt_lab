CREATE TABLE auth_logs
(
    id         BIGSERIAL PRIMARY KEY,
    username   VARCHAR(255),
    token      VARCHAR(255),
    issued_at  TIMESTAMP,
    expires_at TIMESTAMP
);