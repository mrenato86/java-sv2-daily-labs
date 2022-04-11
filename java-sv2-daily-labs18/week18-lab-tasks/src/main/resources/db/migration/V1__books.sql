create table books(
    id bigint auto_increment,
    author varchar(255),
    title varchar(255),
    price bigint,
    pieces bigint,
    constraint pk_books primary key(id)
);