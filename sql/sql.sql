create database FlowerSales;

use FlowerSales;


-- 详细情况表
create table detail(
    id int(10) NOT NULL auto_increment primary key,
    name varchar(50) NOT NULL,
    manager varchar(50) NOT NULL,
    instore dateTime NOT NULL,
    price decimal(10,2) NOT NULL,
    tid int(50) not null
);


insert into detail values (NULL,"金钟吊兰","杨牛马","2015-3-10",20.2,1);
insert into detail values (NULL,"绿球","陈牛马","2015-3-10",30.3,2);
insert into detail values (NULL,"水粉荷语","捏牛马","2015-3-10",40.4,3);




-- 类别
create table type(
    id int(10)  NOT NULL auto_increment primary key,
    name varchar(20) NOT NULL,
    other varchar(20) NOT NULL
);

insert into type values (NULL,"兰花类","兰花类");
insert into type values (NULL,"菊花类","菊花类");
insert into type values (NULL,"荷花类","荷花类");
