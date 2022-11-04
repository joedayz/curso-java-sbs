create sequence hibernate_sequence start with 1 increment by 1;
create table t_artists (id bigint not null, bio varchar(3000), created_date timestamp not null, name varchar(100) not null, primary key (id));
create table t_customers (id bigint not null, created_date timestamp not null, e_mail varchar(255) not null, first_name varchar(50) not null, last_name varchar(50) not null, primary key (id));
create table t_items (DTYPE varchar(31) not null, id bigint not null, created_date timestamp not null, description varchar(3000), price numeric(19,2) not null, title varchar(100) not null, isbn varchar(15), language varchar(20), nb_of_pages integer, publication_date date, artist_fk bigint, publisher_fk bigint, primary key (id));
create table t_publishers (id bigint not null, created_date timestamp not null, name varchar(50) not null, primary key (id));
alter table t_items add constraint FKr3152tukbog585dik5qwonldg foreign key (artist_fk) references t_artists;
alter table t_items add constraint FKi6lqpcqfnc4dtsp9w473p5kkj foreign key (publisher_fk) references t_publishers;
