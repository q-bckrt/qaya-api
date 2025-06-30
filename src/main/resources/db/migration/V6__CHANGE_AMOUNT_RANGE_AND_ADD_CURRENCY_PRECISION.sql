SET search_path TO public;

-- 1. Update all amount fields to support crypto-level precision
ALTER TABLE transactions
    ALTER COLUMN amount TYPE NUMERIC(38,8);

ALTER TABLE recurring_transactions
    ALTER COLUMN amount TYPE NUMERIC(38,8);

ALTER TABLE saving_goals
    ALTER COLUMN target_amount TYPE NUMERIC(38,8),
    ALTER COLUMN current_amount TYPE NUMERIC(38,8),
    ALTER COLUMN suggested_amount TYPE NUMERIC(38,8);

-- 2. Add precision column to currency table (default to 2 for fiat currency)
ALTER TABLE currencies
    ADD COLUMN IF NOT EXISTS precision INTEGER NOT NULL DEFAULT 2;