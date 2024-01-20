--
ALTER TABLE contacts ADD CONSTRAINT first_last_name_unu UNIQUE(first_name, last_name);
-- CREATE UNIQUE INDEX first_name_last_name
--     ON contacts (first_name, last_name);