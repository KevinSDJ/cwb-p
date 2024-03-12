drop table if exists users_roles;
drop table if exists users;
drop table if exists roles;

create table roles (
    id SERIAL primary key,
    name varchar not null unique
);

create table users (
    id uuid default gen_random_uuid() primary key unique,
    name varchar(60) not null,
    surname  varchar(80) not null,
    fullname varchar(120) not null unique,
    email varchar(70) not null unique,
    password varchar(60) not null,
    picture_profile bytea
);

create table users_roles (
    user_id uuid references users(id) on delete cascade,
    role_id INTEGER references roles(id) on delete cascade,
    unique(user_id,role_id),
    primary key(user_id,role_id)
);