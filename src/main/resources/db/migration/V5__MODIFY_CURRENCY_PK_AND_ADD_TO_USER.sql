SET search_path TO public;

--
ALTER TABLE accounts DROP CONSTRAINT IF EXISTS fk_accounts_currency;
ALTER TABLE accounts DROP COLUMN IF EXISTS currency_id;
--
ALTER TABLE currencies DROP CONSTRAINT IF EXISTS pk_currencies;
ALTER TABLE currencies DROP COLUMN if EXISTS id;
--
ALTER TABLE currencies ADD CONSTRAINT pk_currencies PRIMARY KEY (code);
--
ALTER TABLE accounts ADD COLUMN currency VARCHAR(16);
ALTER TABLE accounts ALTER COLUMN currency SET NOT NULL;
ALTER TABLE accounts
    ADD CONSTRAINT fk_accounts_currency FOREIGN KEY (currency) REFERENCES currencies(code);
--
ALTER TABLE users ADD COLUMN currency VARCHAR(16);
ALTER TABLE users ALTER COLUMN currency SET NOT NULL;
ALTER TABLE users
    ADD CONSTRAINT fk_users_currency FOREIGN KEY (currency) REFERENCES currencies(code);