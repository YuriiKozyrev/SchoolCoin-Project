-- diary_accounts
INSERT INTO diary_accounts (id, name, password)
values (1, 'Bob', '111');

INSERT INTO diary_accounts (id, name, password)
values (2, 'John', '111');

INSERT INTO diary_accounts (id, name, password)
values (3, 'Alla', '111');

ALTER SEQUENCE diary_account_seq RESTART WITH 4;


-- game_accounts
INSERT INTO game_accounts(id, name, password, game_store_name)
values (1, 'Bob_game', '111', 'Steam');

INSERT INTO game_accounts(id, name, password, game_store_name)
values (2, 'John_game', '111', 'Steam');

INSERT INTO game_accounts(id, name, password, game_store_name)
values (3, 'Alla_game', '111', 'Steam');

ALTER SEQUENCE game_account_seq RESTART WITH 4;


-- users
INSERT INTO users(id, name, password, archive, role)
values (1, 'Bob', '111', false, 'STUDENT');

INSERT INTO users(id, name, password, archive, role)
values (2, 'Bob_parents', '111', false, 'PARENT');

INSERT INTO users(id, name, password, archive, role)
values (3, 'John', '111', false, 'STUDENT');

INSERT INTO users(id, name, password, archive, role)
values (4, 'John_parents', '111', false, 'PARENT');

INSERT INTO users(id, name, password, archive, role)
values (5, 'admin', '111', false, 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 6;

