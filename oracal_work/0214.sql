drop table 사원;
drop table 대출;
create table 사원 (사번 varchar2(10), 이름 varchar2(10));
create table 대출 (사번 varchar2(10), 도서 varchar2(10));
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0001', '홍길동');
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0002', '김치국');
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0003', '안경태');
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0004', '박호순');
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0005', '한국인');
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0006', '이호빵');

INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0301');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0002', 'T0302');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0203');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0401');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0005', 'T0501');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0201');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0204');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0306');
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0008', 'T0404');

commit;

select * from 사원;
select * from 대출;

-- Q1) 이길동 학생이 수강한 교수명과 성적을 구하시오.
select a.학번, b.성적, c.교수명 from 학생 a
inner join 수강 b on a.학번 = b.학번
inner join 설강 c on b.번호 = c.번호
where 이름='이길동';

select a.학번, b.성적, c.교수명 from 학생 a, 수강 b, 설강 c
where a.학번 = b.학번 and b.번호 = c.번호 and 이름='이길동';

-- Q2) 최씨성을 갖는 학생의 모든정보를 구하라.
select * from 학생 a, 수강 b, 설강 c
where a.학번 = b.학번 and b.번호 = c.번호 and 이름 like '최%';

-- Q3) 최길동 학생의 학년,이름,과목번호,성적을 구하시오.
select 학년,이름,b.번호,성적 from 학생 a
inner join 수강 b on a.학번= b.학번
inner join 설강 c on b.번호=c.번호
where 이름='최길동';


-- <실습3> - emp, dept, slagrade 테이블 이용
-- Q1) 각각의 사원의 연봉에 따른 등급을 출력하시오.(사원이름,연봉,등급순으로 출력)


-- Q2) 사원들의 job과 부서명을 구하시오. (이름,job, 부서명순으로 출력)
select a.ename,a.JOB,b.department_name from emp a,departments b
where a.deptno = b.department_id;
select ename,JOB,department_name from emp
inner join departments on emp.deptno = departments.department_id;




