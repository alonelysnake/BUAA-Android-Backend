SET FOREIGN_KEY_CHECKS=0;

drop table if exists activity;

#
create table activity(
    act_id int not null auto_increment,
    start datetime not null ,
    end datetime,
    imgUrl varchar(1024) not null,
    description varchar(1024) not null,
    a_id int,
    primary key (act_id),
    foreign key (a_id) references admin(a_id)
)default charset=utf8;