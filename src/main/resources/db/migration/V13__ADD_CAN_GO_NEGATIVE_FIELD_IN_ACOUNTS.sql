SET search_path TO public;

ALTER TABLE accounts
    ADD COLUMN allow_overdraft boolean NOT NULL DEFAULT false;