SET search_path TO public;


ALTER TABLE categories
    ALTER COLUMN type TYPE varchar(32) USING type::varchar(32),
    ALTER COLUMN type SET DEFAULT 'EXPENSE';

ALTER TABLE saving_goals
    ALTER COLUMN frequency TYPE varchar(32) USING frequency::varchar(32),
    ALTER COLUMN frequency SET DEFAULT 'MONTHLY';

ALTER TABLE recurring_transactions
    ALTER COLUMN frequency TYPE varchar(32) USING frequency::varchar(32),
    ALTER COLUMN frequency SET DEFAULT 'MONTHLY';


DROP TYPE category_type;
DROP TYPE frequency_type;

