CREATE TABLE guests
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255),
    surname VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

create table guests_hosts
(
    guest_id        BIGSERIAL,
    host_id      BIGSERIAL,
    PRIMARY KEY (guest_id, host_id),
    CONSTRAINT fk_guest
        FOREIGN KEY (guest_id)
            REFERENCES guests (id) on delete cascade,
    CONSTRAINT fk_host
        FOREIGN KEY (host_id)
            REFERENCES hosts (id) on delete cascade
);