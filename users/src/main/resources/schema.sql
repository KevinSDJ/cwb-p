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
    constraint fk_role foreign key(role_id) references role(id)
);

create table users_roles (
    con
)