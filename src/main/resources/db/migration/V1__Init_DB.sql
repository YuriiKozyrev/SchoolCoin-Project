--Users
create sequence user_seq start 1 increment 1;
create table users (
    id int8 not null,
    name varchar(255),
    password varchar(255),
    archive boolean not null,
    role varchar(255),
    primary key (id)
);

--Grades
create sequence grade_seq start 1 increment 1;
create table grades (
    id int8 not null,
    grade_value int8 not null,
    subject varchar(255),
    grade_date timestamp,
    grade_type varchar(255),
    has_taken boolean not null,
    rate int8,
    primary key (id)
);

--Game Accounts
create sequence game_account_seq start 1 increment 1;
create table game_accounts (
    id int8 not null,
    name varchar(255),
    password varchar(255),
    game_store_name varchar(255),
    primary key (id)
);

--Diary Accounts
create sequence diary_account_seq start 1 increment 1;
create table diary_accounts (
    id int8 not null,
    name varchar(255),
    password varchar(255),
    primary key (id)
);
