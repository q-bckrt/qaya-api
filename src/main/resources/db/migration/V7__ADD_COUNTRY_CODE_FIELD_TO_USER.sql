SET search_path TO public;

ALTER TABLE users
    ADD COLUMN country_code VARCHAR(2) NOT NULL DEFAULT 'BE';