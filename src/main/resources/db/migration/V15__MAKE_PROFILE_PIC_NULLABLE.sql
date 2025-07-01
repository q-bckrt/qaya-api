SET search_path TO public;

ALTER TABLE users
    ALTER COLUMN profile_picture DROP NOT NULL,
    ALTER COLUMN profile_picture DROP DEFAULT;