CREATE TABLE contacts (
       id uuid DEFAULT uuid_generate_v4 (),
       first_name VARCHAR NOT NULL,
       last_name VARCHAR NOT NULL,
       email VARCHAR NOT NULL,
       phone VARCHAR,
       PRIMARY KEY (id)
);