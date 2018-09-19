CREATE SCHEMA IF NOT EXISTS catalog;

CREATE SEQUENCE IF NOT EXISTS catalog.id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 2147483647
  START 1
  CACHE 1;
  
CREATE TABLE IF NOT EXISTS catalog.coin
(
  id integer NOT NULL DEFAULT nextval('catalog.id_seq'),
  currency character varying(100) NOT NULL,
  value integer NOT NULL,
  year integer NOT NULL,
  mint character varying(255) NOT NULL,
  description character varying(255),
  CONSTRAINT coinkey PRIMARY KEY (id)
);

CREATE TABLE catalog."user"
(
  login character varying(60) NOT NULL,
  password character varying(60) NOT NULL,
  admin boolean NOT NULL,
  CONSTRAINT loginkey PRIMARY KEY (login)
);

INSERT INTO catalog."user"(login, password, admin) VALUES ('admin', '$2a$10$7Xalpo5Ybd1bzRq.p.xQVeLtFDUVXcLauVjy1ebjBO72kOaPYCF0O', true);
INSERT INTO catalog."user"(login, password, admin) VALUES ('user1', '$2a$10$zVwGuQxJLYMSixtXk40/8O/Q350OfWrQalaYS7oPbfSZXLowv4tPO', false);
INSERT INTO catalog."user"(login, password, admin) VALUES ('user2', '$2a$10$cPB0OQ4ez2jUUiBZNyaHpuAzmJo1Y7KiDe5IT8as7TF5SPpHrztCm', false);

INSERT INTO catalog.coin(currency, value, year, mint, description) VALUES ('рубль', 1, 1998, 'Московский монетный двор', '');
INSERT INTO catalog.coin(currency, value, year, mint, description) VALUES ('копейка', 10, 2007, 'Московский монетный двор', '');
INSERT INTO catalog.coin(currency, value, year, mint, description) VALUES ('копейка', 50, 2006, 'Питерский монетный двор', '');
INSERT INTO catalog.coin(currency, value, year, mint, description) VALUES ('рубль', 2, 2001, 'Питерский монетный двор', '');




