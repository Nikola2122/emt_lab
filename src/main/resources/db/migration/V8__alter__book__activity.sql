ALTER TABLE book_activities
    ADD COLUMN accommodation_id BIGINT
        REFERENCES accommodations (id)
            ON DELETE CASCADE;
ALTER TABLE book_activities
    ADD COLUMN host_id BIGINT
        REFERENCES hosts (id)
            ON DELETE CASCADE;