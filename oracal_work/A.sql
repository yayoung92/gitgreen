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
