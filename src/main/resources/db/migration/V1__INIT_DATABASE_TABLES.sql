SET search_path TO public;

CREATE TABLE users
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    display_name varchar(256) NOT NULL,
    email varchar(256) NOT NULL,
    locale varchar(16) NOT NULL,
    timezone varchar(64) NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_users PRIMARY KEY (id)
);


CREATE TYPE category_type AS ENUM ('EXPENSE', 'INCOME');

CREATE TABLE categories
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    label varchar(256) NOT NULL,
    description text,
    type category_type NOT NULL DEFAULT 'EXPENSE',
    icon_key varchar(256) NOT NULL,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_categories PRIMARY KEY (id),
    CONSTRAINT fk_categories_user FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE tags
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    label varchar(256) NOT NULL,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_tags PRIMARY KEY (id),
    CONSTRAINT fk_tags_user FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE currencies
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    code varchar(16) NOT NULL,
    symbol varchar(16) NOT NULL,
    currency_name varchar(256) NOT NULL,
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_currencies PRIMARY KEY (id)
);


CREATE TABLE accounts
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(256) NOT NULL,
    description text,
    icon_key varchar(256) NOT NULL,
    currency_id uuid NOT NULL,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_accounts PRIMARY KEY (id),
    CONSTRAINT fk_accounts_currency FOREIGN KEY (currency_id) REFERENCES currencies(id),
    CONSTRAINT fk_accounts_user FOREIGN KEY (user_id) REFERENCES users(id)
);


create type frequency_type AS ENUM ('NONE', 'DAILY', 'WEEKLY', 'BIWEEKLY', 'MONTHLY', 'QUARTERLY', 'YEARLY', 'ONE_TIME');

CREATE TABLE saving_goals
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(256) NOT NULL,
    description text,
    account_id uuid NOT NULL,
    target_amount numeric(20, 2) NOT NULL,
    current_amount numeric(20, 2) NOT NULL DEFAULT 0,
    start_date timestamp with time zone,
    due_date timestamp with time zone,
    frequency frequency_type NOT NULL DEFAULT 'NONE',
    suggested_amount numeric(20, 2) NOT NULL DEFAULT 0,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_saving_goals PRIMARY KEY (id),
    CONSTRAINT fk_saving_goals_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_saving_goals_account FOREIGN KEY (account_id) REFERENCES accounts(id)
);


CREATE TABLE transactions
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(256) NOT NULL,
    description text,
    amount numeric(20, 2) NOT NULL,
    date timestamp with time zone NOT NULL DEFAULT now(),
    account_id uuid NOT NULL,
    category_id uuid NOT NULL,
    saving_goal_id uuid,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_transactions PRIMARY KEY (id),
    CONSTRAINT fk_transactions_account FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT fk_transactions_category FOREIGN KEY (category_id) REFERENCES categories(id),
    CONSTRAINT fk_transactions_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_transactions_saving_goal FOREIGN KEY (saving_goal_id) REFERENCES saving_goals(id)
);

-- Joint Table for Transactions and Tags
CREATE TABLE transactions_tags
(
    transaction_id uuid NOT NULL,
    tag_id uuid NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT now(),

    CONSTRAINT pk_transactions_tags PRIMARY KEY (transaction_id, tag_id),
    CONSTRAINT fk_transactions_tags_transaction FOREIGN KEY (transaction_id) REFERENCES transactions(id),
    CONSTRAINT fk_transactions_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);


CREATE TABLE recurring_transactions
(
    id uuid NOT NULL DEFAULT gen_random_uuid(),
    title varchar(256) NOT NULL,
    description text,
    amount numeric(20, 2) NOT NULL,
    start_date timestamp with time zone NOT NULL DEFAULT now(),
    end_date timestamp with time zone,
    next_occurrence timestamp with time zone NOT NULL DEFAULT now(),
    frequency frequency_type NOT NULL DEFAULT 'MONTHLY',
    auto_create boolean NOT NULL DEFAULT true,
    account_id uuid NOT NULL,
    category_id uuid NOT NULL,
    saving_goal_id uuid,
    user_id uuid NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL DEFAULT now(),
    is_deleted boolean NOT NULL DEFAULT false,

    CONSTRAINT pk_recurring_transactions PRIMARY KEY (id),
    CONSTRAINT fk_recurring_transactions_account FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT fk_recurring_transactions_category FOREIGN KEY (category_id) REFERENCES categories(id),
    CONSTRAINT fk_recurring_transactions_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_recurring_transactions_saving_goal FOREIGN KEY (saving_goal_id) REFERENCES saving_goals(id)
);

-- Joint Table for Recurring Transactions and Tags
CREATE TABLE recurring_transactions_tags
(
    recurring_transaction_id uuid NOT NULL,
    tag_id uuid NOT NULL,
    updated_at timestamp with time zone NOT NULL DEFAULT now(),

    CONSTRAINT pk_recurring_transactions_tags PRIMARY KEY (recurring_transaction_id, tag_id),
    CONSTRAINT fk_recurring_transactions_tags_recurring_transaction FOREIGN KEY (recurring_transaction_id) REFERENCES recurring_transactions(id),
    CONSTRAINT fk_recurring_transactions_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);
