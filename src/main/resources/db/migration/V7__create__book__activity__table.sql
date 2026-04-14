CREATE TABLE book_activities
(
    id         BIGSERIAL PRIMARY KEY,
    acc_name   VARCHAR(255),
    book_time  TIMESTAMP,
    successful BOOLEAN,
    full_room BOOLEAN
);