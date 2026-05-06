create table users (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    email varchar(255) not null unique,
    username varchar(255) unique,
    password varchar(255) unique,
    role varchar(255)
);