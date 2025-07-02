SET search_path TO public;

ALTER TABLE transactions
    ADD COLUMN type varchar(32) NOT NULL DEFAULT 'EXPENSE' CHECK (type IN ('EXPENSE', 'INCOME', 'TRANSFER', 'ADJUSTMENT'));

ALTER TABLE categories
    ADD CONSTRAINT check_type_valid CHECK (type IN ('EXPENSE', 'INCOME'));