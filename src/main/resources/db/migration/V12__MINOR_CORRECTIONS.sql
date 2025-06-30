SET search_path TO public;

ALTER TABLE users
    DROP COLUMN IF EXISTS "profile_pic";

ALTER TABLE users
    ALTER COLUMN "profile_picture"
        SET DEFAULT NULL;