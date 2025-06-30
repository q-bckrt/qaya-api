SET search_path TO public;

-- Joint table for accounts and users
CREATE TABLE accounts_users
(
    account_id uuid NOT NULL,
    user_id uuid NOT NULL,
    role varchar(64) NOT NULL DEFAULT 'USER',
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_accounts_users PRIMARY KEY (account_id, user_id),
    CONSTRAINT fk_accounts_users_account FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT fk_accounts_users_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Joint table for saving goals and users
CREATE TABLE saving_goals_users
(
    saving_goal_id uuid NOT NULL,
    user_id uuid NOT NULL,
    role varchar(64) NOT NULL DEFAULT 'USER',
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_saving_goals_users PRIMARY KEY (saving_goal_id, user_id),
    CONSTRAINT fk_saving_goals_users_saving_goal FOREIGN KEY (saving_goal_id) REFERENCES saving_goals(id),
    CONSTRAINT fk_saving_goals_users_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Modifying Accounts and Saving Goals tables to function with joint tables
ALTER TABLE accounts
    DROP COLUMN user_id;
ALTER TABLE saving_goals
    DROP COLUMN user_id;


-- Adding is_deleted column to existing joint tables
ALTER TABLE transactions_tags
    ADD COLUMN is_deleted boolean NOT NULL DEFAULT false;

ALTER TABLE recurring_transactions_tags
    ADD COLUMN is_deleted boolean NOT NULL DEFAULT false;

