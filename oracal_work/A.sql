CREATE TABLE USERS 
(	
    IDX NUMBER, 
    EMAIL VARCHAR2(20), 
    ADDR VARCHAR2(20), 
    PASSWORD VARCHAR2(20), 
    NAME VARCHAR2(20)
) ;

CREATE TABLE TODO 
(   
    IDX NUMBER, 
    USERS_IDX NUMBER, 
    TITLE VARCHAR2(20), 
    "CONTENT" VARCHAR2(20), 
    FINISHDATE DATE
);

commit;

create SEQUENCE usersIdx;
create SEQUENCE todoIdx;


INSERT INTO TODO (IDX, USERS_IDX, TITLE, CONTENT, FINISHDATE) 
VALUES (todoIdx.nextval, 21, '공부', '504호로', TO_DATE(sysdate, 'YYYY-MM-DD HH24:MI:SS'));

select * from users;
select * from todo;

select usersIdx.currval from dual;

select users_idx from todo minus select idx from users;

INSERT INTO TODO(IDX, USERS_IDX, TITLE, CONTENT, FINISHDATE)
VALUES (todoIdx.nextval, 42, 'test', 'contentdd', sysdate);


select * from todo order by idx desc;
select * from users;

select * from todo a, users b
where a.users_idx = b.idx;

select * from todo a
left outer join users b on a.users_idx = b.idx;

select a.idx, a.title, a.content, a.finishdate, b.name from todo a, users b
where a.users_idx = b.idx and a.status is null;

UPDATE todo SET STATUS = 'C' 
WHERE idx = '38';

commit;
select * from todo;

select a.idx, a.title, a.content, a.finishdate, b.name
from todo a, users b
where a.users_idx = b.idx and a.status ='C'
order by a.idx desc;

