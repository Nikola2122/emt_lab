CREATE OR REPLACE VIEW accommodation_view AS
SELECT
    a.id,
    a.name,
    a.category,
    a.num_rooms AS num_rooms,
    CONCAT(h.name, ' ', h.surname) AS host_name_and_surname,
    c.name AS country_name
FROM accommodations a
         JOIN hosts h ON a.host_id = h.id
         LEFT JOIN countries c ON h.country_id = c.id;