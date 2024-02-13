-- ex1) 학생들의 평균 신장을 구하라
select avg(신장),이름 as a from 학생 group by 이름;

-- ex2) 소속별로 학생들의 평균 신장을 구하시오.
select 소속, round(avg(신장),2) as 평균신장 from 학생 group by 소속; 

-- ex3) 수강테이블에서 학생별 평균성적을 구한후 평균성적이 높은 순서대로 정렬하시오.
select 학번, avg(성적) from 수강 group by 학번 order by avg(성적) desc;

-- ex4) 교수번호 102인 교수가 설강한 과목을 수강하는 학생의 수를 계산하라.
select count(distinct 학번) from 수강 where 번호='101';
select count(학번) from 수강 where 번호='101';

select * from 수강;

select * from(
    select 학번, count(*) as cnt from 수강 group by 학번
) a
where a.cnt >=3;
-- ex5) 세과목 이상 수강하는 학생의 학번을 구하시오.
select 학번, count(*) from 수강 group by 학번;
select 학번, count(*) from 수강 group by 학번 having count(*)>=3;

-- ex6) 가장 높은 급여와 가장 낮은 급여를 구하시오.
select min(sal),max(sal) from emp;

-- ex7) 커미션을 받는 사원의 수를 구하시오. 
select count(*) from emp
where comm is not null;

-- ex8) 부서번호가 10인 사원중에 커미션을 받는 사원의 수를 구하시오.
select count(*) from emp where deptno=10 and comm is not null;

-- ex9) 사원테이블에서 job의 종류는 몇 개인가?
select job,count(job) from emp group by job;
select count(*) from(
    select job from emp group by job
);

-- ex10) 부서별로 급여의 최고액을 구한 후 급여가 많은 순서데로 정렬하시오.
select deptno, max(sal) from emp group by deptno order by max(sal) desc;

-- ex11) 부서별 평균 급여가 2000이상인 부서들만 부서별 평균을 구하시오.
select deptno,round(avg(sal),2) from emp group by deptno having avg(sal)>=2000;

-- ex12) 급여가 1000이상인 사원들만 부서별 평균급여를 구한 후 부서별 평균 급여가 2000이상인 부서만 부서번호와 부서별 평균급여를 구하시오.
select deptno, avg(sal) from emp where sal>=1000 group by deptno having avg(sal)>=2000;

select * from departments;
select * from emp;
select deptno from emp where ename='SMITH';
select * from departments where department_id = 20;
select * from departments d
inner join emp e on e.deptno = d.department_id;
where e.ename='SMITH';
