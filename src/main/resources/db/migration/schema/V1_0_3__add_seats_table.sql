-- Create seats table
CREATE TABLE IF NOT EXISTS seats
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    theater_id  UUID        NOT NULL,
    name        VARCHAR(10) NOT NULL,
    row_label   VARCHAR(5)  NOT NULL,
    seat_number INT         NOT NULL,
    CONSTRAINT seats_theater_fk FOREIGN KEY (theater_id) REFERENCES theater (id) ON DELETE CASCADE,
    CONSTRAINT seats_theater_name_unique UNIQUE (theater_id, name)
);

