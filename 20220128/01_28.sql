select * from member;

select count(*) from member where id = 'mol';

select case when count(*) = 1 then 0 else 1 end as t
from member where id = 'micol';

create table notice(
    notice_id number not null primary key,
    notice_writer varchar2(50) not null,
    notice_title varchar2(200) not null,
    notice_subject varchar2(4000),
    notice_date date default sysdate,
    notice_hit number default 0
);

insert into notice values(1,'홍길동','공지사항 입니다.','공지사항을 등록합니다.',sysdate,0);

select * from notice;

commit;
