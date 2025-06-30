SET search_path TO public;

ALTER TABLE users
    ADD COLUMN "profile_pic" VARCHAR(255) DEFAULT NULL;