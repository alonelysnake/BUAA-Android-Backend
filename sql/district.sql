SET FOREIGN_KEY_CHECKS=0;

drop table if exists district;

create table district(
    d_id int not null auto_increment,
    d_name varchar(10) not null ,
    primary key (d_id)
)default charset=utf8;

insert into district(d_name) values ('学一食堂');
insert into district(d_name) values ('学二食堂');
insert into district(d_name) values ('学三食堂');
insert into district(d_name) values ('学四食堂');
insert into district(d_name) values ('学五食堂');