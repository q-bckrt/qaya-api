-- This user is linked through its id to an actual user in the auth database and will be used for development purpose
INSERT INTO users (id, display_name, email, locale, timezone)
VALUES (
           'b7e76cdb-e6b3-4ede-9452-f1b873ad157e',  -- from Supabase
           'Quentin',
           'quentin.test1@gmail.com',
           'en',
           'Europe/Brussels'
       );