-- Countries
INSERT INTO countries (name, continent)
VALUES ('Germany', 'Europe'),
       ('France', 'Europe'),
       ('Italy', 'Europe'),
       ('Spain', 'Europe'),
       ('United States', 'North America'),
       ('Canada', 'North America'),
       ('Japan', 'Asia'),
       ('China', 'Asia'),
       ('Brazil', 'South America'),
       ('Australia', 'Australia');

-- Hosts
INSERT INTO hosts (name, surname, country_id, created_at, updated_at)
VALUES ('John', 'Smith', 1, NOW(), NOW()),
       ('Marie', 'Dubois', 2, NOW(), NOW()),
       ('Luca', 'Bianchi', 3, NOW(), NOW()),
       ('Carlos', 'Garcia', 4, NOW(), NOW()),
       ('James', 'Johnson', 5, NOW(), NOW()),
       ('Emma', 'Wilson', 6, NOW(), NOW()),
       ('Kenji', 'Tanaka', 7, NOW(), NOW()),
       ('Wei', 'Zhang', 8, NOW(), NOW()),
       ('Pedro', 'Silva', 9, NOW(), NOW()),
       ('Oliver', 'Brown', 10, NOW(), NOW());

-- Accommodations
INSERT INTO accomodations (name, category, host_id, state, num_rooms, created_at, updated_at)
VALUES ('Berlin Central Room', 'ROOM', 1, 'GOOD', 5, NOW(), NOW()),
       ('Paris Luxury House', 'HOUSE', 2, 'GOOD', 8, NOW(), NOW()),
       ('Rome Modern Flat', 'FLAT', 3, 'GOOD', 4, NOW(), NOW()),
       ('Madrid City Apartment', 'APARTMENT', 4, 'BAD', 6, NOW(), NOW()),
       ('New York Grand Hotel', 'HOTEL', 5, 'GOOD', 40, NOW(), NOW()),
       ('Toronto Comfort Motel', 'MOTEL', 6, 'GOOD', 20, NOW(), NOW()),
       ('Tokyo Small Room', 'ROOM', 7, 'BAD', 3, NOW(), NOW()),
       ('Shanghai Business Hotel', 'HOTEL', 8, 'GOOD', 35, NOW(), NOW()),
       ('Rio Beach House', 'HOUSE', 9, 'GOOD', 7, NOW(), NOW()),
       ('Sydney Harbor Apartment', 'APARTMENT', 10, 'BAD', 5, NOW(), NOW());