SET search_path TO public

ALTER TABLE users
    ALTER COLUMN country_code DROP NOT NULL,
    ALTER COLUMN country_code DROP DEFAULT;