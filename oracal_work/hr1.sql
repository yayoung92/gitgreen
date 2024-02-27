create user usertodo identified by "123";
grant connect, resource to usertodo;

CREATE TABLE tb_smart_crud (
  autoid number primary KEY NOT NULL,
  firstname varchar(50) DEFAULT NULL,
  lastname varchar(50) DEFAULT NULL,
  gender varchar(50) DEFAULT NULL
);

commit;

select * from tb_smart_crud;

insert into tb_smart_crud(autoid, firstname, lastname, gender)
values('AT' || auto.nextval,'ggg11','test11','여');

create SEQUENCE TB_SMART_SEQ;
ALTER SEQUENCE TB_SMART_SEQ
INCREMENT BY 10 MAXVALUE 100000; 

DROP SEQUENCE AUTO;

SELECT TB_SMART_SEQ.NEXTVAL FROM DUAL;
SELECT TB_SMART_SEQ.CURRVAL FROM DUAL;

INSERT INTO TB_SMART_CRUD VALUES(TB_SMART_SEQ.NEXTVAL,'AAA','BBB','남');

update tb_smart_crud
set firstname='aaaaa', lastname='qwerqwer', gender='여자'
where autoid=220;

delete tb_smart_crud
where autoid=2;

select * from tb_smart_crud;
commit;

select * from tb_smart_crud where concat(fristname, lastname) like 'e' order by autoid desc;