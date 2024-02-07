select 이름,신장,소속 from 학생
where 신장>=170;

-- 5
select * from 수강
where 성적 between 80 and 90;
select * from 수강
where 성적 >=80 and 성적 <=90;

-- 6
select * from 학생
where 소속<>'CD';
select * from 학생
where 소속 != 'CD';

-- 7
select 교수명,과목명 from 설강
where 교수명 like '김%';

-- 8
select substr(교수명,1,2),과목명 from 설강
where 교수명 like '이_';
select 교수명,과목명 from 설강
where trim(교수명) like '이_';

select * from 설강;
update 설강 set 교수명='이상' where 번호='104';

commit;

-- 9
select * from 설강
where 교수명 not like '김%';

-- 10
select 학년,신장 from 학생
where 소속='CD' and 신장>=170;

-- 11
select * from 학생
order by 신장 desc;

-- 12
select 신장 from 학생
where 소속='CD'
order by 신장 desc;

-- 13
select * from 학생
where 소속!='ID' and 소속!='ED';
select * from 학생
where 소속 not in ('ID','ED');

-- 14 사원테이블에서 연봉 2500이상인 직원의 사원번호,이름,연봉을 구하시오.
select empno,ename,sal from emp
where SAL>=2500;

select * from emp;

-- 15 성과급을 받지 않는 사원의 이름과 연봉을 구하시오.
select ename,sal from emp
where comm is null;

-- 16 입사일이 82년 이후인 사원의 모든정보를 구하시오. 
select * from emp
where to_char(hiredate,'yy')>82;
select * from emp
where hiredate>='82/01/01';

-- 17 연봉이 2000이상 또는 job이 salesman인 사원의 모든정보를 구하시오.
select upper('saleman') as a, lower('salesman') as b from dual;
select * from emp
where job=upper('saleman') and sal>=2000;

-- 18 사원의 이름중 A가 들어가있는 사원의 모든정보를 구하시오.
select * from emp
where ename like '%A%';

-- 19 연봉이 높은 순서대로 정렬하시오.
select * from emp
order by sal desc;

-- 20 부서번호가 10또는 20인 사원의 이름과 연봉을 구하시오
select ename, sal from emp
where deptno in ('10','20');
