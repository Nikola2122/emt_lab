CREATE MATERIALIZED VIEW IF NOT EXISTS accommodation_mat_view AS
SELECT
    ROW_NUMBER() OVER () AS id,
    a.category AS category,
    COUNT(*) AS total_accommodations,
    SUM(a.num_rooms) AS total_rooms,
    AVG(a.num_rooms) AS avg_rooms
FROM accommodations a
GROUP BY a.category;