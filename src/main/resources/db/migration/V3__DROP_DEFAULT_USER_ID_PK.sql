SET search_path TO public;

-- Remove default value from users.id, since it's gonna be the real auth db user id
ALTER TABLE users
    ALTER COLUMN id DROP DEFAULT;
