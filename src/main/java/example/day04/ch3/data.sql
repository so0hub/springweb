drop database if exists mydb0303;
create database mydb0303;
use mydb0303;
create table member(
                       id bigint primary key auto_increment,
                       name varchar(255)
);
insert into member(id,name) values( 1 , 'name 1' );
insert into member(id,name) values( 2 , 'name 2' );
insert into member(id,name) values( 3 , 'name 3' );
select * from member;