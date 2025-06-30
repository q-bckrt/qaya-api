SET search_path TO public;

-- ADDING INDEXES FOR PERFORMANCE OPTIMIZATION

-- Join Tables: fast user-to-resource lookup
CREATE INDEX idx_accounts_users_user_id ON accounts_users(user_id);
CREATE INDEX idx_saving_goals_users_user_id ON saving_goals_users(user_id);

-- Transactions: listing, sync, and ownership
CREATE INDEX idx_transactions_account_id ON transactions(account_id);
CREATE INDEX idx_transactions_user_id ON transactions(user_id);
CREATE INDEX idx_transactions_updated_at ON transactions(updated_at);

-- Saving Goals & Accounts: sync support
CREATE INDEX idx_saving_goals_updated_at ON saving_goals(updated_at);
CREATE INDEX idx_accounts_updated_at ON accounts(updated_at);

-- Tags (many-to-many): improve joins
CREATE INDEX idx_transactions_tags_transaction_id ON transactions_tags(transaction_id);
CREATE INDEX idx_transactions_tags_tag_id ON transactions_tags(tag_id);
CREATE INDEX idx_recurring_transactions_tags_transaction_id ON recurring_transactions_tags(recurring_transaction_id);
CREATE INDEX idx_recurring_transactions_tags_tag_id ON recurring_transactions_tags(tag_id);

-- Lookup Tables: quick name/code searches
CREATE INDEX idx_tags_label ON tags(label);
CREATE INDEX idx_categories_name ON categories(label);
CREATE INDEX idx_currencies_code ON currencies(code);

-- Small Correction: Add profile_picture to users table
ALTER TABLE users
    ADD COLUMN IF NOT EXISTS profile_picture varchar(256);