CREATE TABLE countries
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255),
    continent VARCHAR(255)
);

CREATE TABLE hosts
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    surname    VARCHAR(255),
    country_id BIGINT    NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_host_country
        FOREIGN KEY (country_id)
            REFERENCES countries (id) on delete cascade
);

CREATE TABLE accomodations
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    category   VARCHAR(50),
    state      VARCHAR(50),
    num_rooms  INTEGER,
    host_id    BIGINT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_accommodation_host
        FOREIGN KEY (host_id)
            REFERENCES hosts (id) on delete cascade
);