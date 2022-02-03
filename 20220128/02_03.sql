-- micol / 1234

create table member(
    id varchar2(50) not null primary key,
    password varchar2(512) not null,
    name varchar2(50) not null,
    tel varchar(20),
    address varchar2(200) default '',
    author varchar2(20) default 'USER'
);


select * from member;

insert into member(id, password, name)
values('hong','2345','홍길동');
insert into member(id, password, name, author)
values('micol', '1234', '관리자', 'ADMIN');


commit;

delete from member where id = 'hong';


select count(*) from member where id = 'mol';
select count(*) from member where id = 'micol';

select case when count(*) =1 then 0 else 1 end as t
from member where id='miol'; -- id가 없으면 1 있으면 0

select * from notice;
insert into notice values(1,'홍길동','공지사항입니다','공지사항을 등록',sysdate,0);
commit;

create table notice(
    notice_id number not null primary key,
    notice_writer varchar2(50) not null,
    notice_title varchar2(200) not null,
    notice_subject varchar2(4000) not null,
    notice_date date default sysdate,
    notice__hit number default 0
);