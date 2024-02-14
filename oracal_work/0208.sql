-- ex1) �л����� ��� ������ ���϶�
select avg(����),�̸� as a from �л� group by �̸�;

-- ex2) �ҼӺ��� �л����� ��� ������ ���Ͻÿ�.
select �Ҽ�, round(avg(����),2) as ��ս��� from �л� group by �Ҽ�; 

-- ex3) �������̺��� �л��� ��ռ����� ������ ��ռ����� ���� ������� �����Ͻÿ�.
select �й�, avg(����) from ���� group by �й� order by avg(����) desc;

-- ex4) ������ȣ 102�� ������ ������ ������ �����ϴ� �л��� ���� ����϶�
select count(distinct �й�) from ���� where ��ȣ='102';
select count(�й�) from ���� where ��ȣ='102';

select * from ����;

select * from(
    select �й�, count(*) as cnt from ���� group by �й�
) a
where a.cnt >=3;
-- ex5) ������ �̻� �����ϴ� �л��� �й��� ���Ͻÿ�.
select �й�, count(*) from ���� group by �й�;
select �й�, count(*) from ���� group by �й� having count(*)>=3;

-- ex6) ���� ���� �޿��� ���� ���� �޿��� ���Ͻÿ�.
select min(sal),max(sal) from emp;

-- ex7) Ŀ�̼��� �޴� ����� ���� ���Ͻÿ�. 
select count(*) from emp
where comm is not null;

-- ex8) �μ���ȣ�� 10�� ����߿� Ŀ�̼��� �޴� ����� ���� ���Ͻÿ�.
select count(*) from emp where deptno=10 and comm is not null;

-- ex9) ������̺��� job�� ������ �� ���ΰ�?
select job,count(job) from emp group by job;
select count(*) from(
    select job from emp group by job
);

-- ex10) �μ����� �޿��� �ְ���� ���� �� �޿��� ���� �������� �����Ͻÿ�.
select deptno, max(sal) from emp group by deptno order by max(sal) desc;

-- ex11) �μ��� ��� �޿��� 2000�̻��� �μ��鸸 �μ��� ����� ���Ͻÿ�.
select deptno,round(avg(sal),2) from emp group by deptno having avg(sal)>=2000;

-- ex12) �޿��� 1000�̻��� ����鸸 �μ��� ��ձ޿��� ���� �� �μ��� ��� �޿��� 2000�̻��� �μ��� �μ���ȣ�� �μ��� ��ձ޿��� ���Ͻÿ�.
select deptno, avg(sal) from emp where sal>=1000 group by deptno having avg(sal)>=2000;

-- inner join
select * from departments;
select * from emp;
select deptno from emp where ename='SMITH';
select * from departments where department_id = 20;
select e.ename,d.department_name from departments d
inner join emp e on e.deptno = d.department_id
where e.ename='SMITH';
select * from emp e
inner join departments d on e.deptno = d.department_id;

-- left join
select * from emp e
left outer join departments d on e.deptno = d.department_id;

select * from departments d
left outer join emp e on e.deptno = d.department_id;

-- right join
select * from emp e
right outer join departments d on e.deptno = d.department_id;

select * from departments d
right outer join emp e on e.deptno = d.department_id;

commit;
