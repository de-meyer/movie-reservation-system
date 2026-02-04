-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create function to auto-update updated_at column
CREATE OR REPLACE FUNCTION update_updated_at_column()
    RETURNS TRIGGER AS
'
    BEGIN
        NEW.updated_at = CURRENT_TIMESTAMP;
        RETURN NEW;
    END;
' LANGUAGE plpgsql;

-- 1. Independent tables (no foreign keys)
CREATE TABLE IF NOT EXISTS users
(
    id    UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    name  VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    role  VARCHAR(255) NOT NULL DEFAULT 'GUEST'
);

CREATE TABLE IF NOT EXISTS movies
(
    id               UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    title            VARCHAR(255) NOT NULL,
    description      TEXT,
    image_profile    TEXT,
    image_landscape  TEXT,
    release_year     INT,
    director         VARCHAR(255),
    genre            VARCHAR(100),
    duration_minutes INT,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS theater
(
    id         UUID PRIMARY KEY      DEFAULT uuid_generate_v4(),
    name       VARCHAR(255) NOT NULL,
    capacity   INT,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 2. Dependent tables (with foreign keys)
CREATE TABLE IF NOT EXISTS shows
(
    id         UUID PRIMARY KEY                  DEFAULT uuid_generate_v4(),
    movie_id   UUID                     NOT NULL,
    theater_id UUID                     NOT NULL,
    date       TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT shows_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE,
    CONSTRAINT shows_theater_fk FOREIGN KEY (theater_id) REFERENCES theater (id)

);

CREATE TABLE IF NOT EXISTS reservation
(
    id          UUID PRIMARY KEY   DEFAULT uuid_generate_v4(),
    user_id     UUID      NOT NULL,
    movie_id    UUID,
    theater_id  UUID,
    seat_number INT       NOT NULL,
    date        TIMESTAMP,
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT reservation_user_fk FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT reservation_movie_fk FOREIGN KEY (movie_id) REFERENCES movies (id),
    CONSTRAINT reservation_theater_fk FOREIGN KEY (theater_id) REFERENCES theater (id)
);

-- Triggers for auto-updating updated_at
CREATE OR REPLACE TRIGGER update_movies_updated_at
    BEFORE UPDATE
    ON movies
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE OR REPLACE TRIGGER update_theater_updated_at
    BEFORE UPDATE
    ON theater
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE OR REPLACE TRIGGER update_shows_updated_at
    BEFORE UPDATE
    ON shows
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();

CREATE OR REPLACE TRIGGER update_reservation_updated_at
    BEFORE UPDATE
    ON reservation
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();