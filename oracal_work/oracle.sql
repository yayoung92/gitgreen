select �̸�,����,�Ҽ� from �л�
where ����>=170;

-- 5
select * from ����
where ���� between 80 and 90;
select * from ����
where ���� >=80 and ���� <=90;

-- 6
select * from �л�
where �Ҽ�<>'CD';
select * from �л�
where �Ҽ� != 'CD';

-- 7
select ������,����� from ����
where ������ like '��%';

-- 8
select substr(������,1,2),����� from ����
where ������ like '��_';
select ������,����� from ����
where trim(������) like '��_';

select * from ����;
update ���� set ������='�̻�' where ��ȣ='104';

commit;

-- 9
select * from ����
where ������ not like '��%';

-- 10
select �г�,���� from �л�
where �Ҽ�='CD' and ����>=170;

-- 11
select * from �л�
order by ���� desc;

-- 12
select ���� from �л�
where �Ҽ�='CD'
order by ���� desc;

-- 13
select * from �л�
where �Ҽ�!='ID' and �Ҽ�!='ED';
select * from �л�
where �Ҽ� not in ('ID','ED');

-- 14 ������̺��� ���� 2500�̻��� ������ �����ȣ,�̸�,������ ���Ͻÿ�.
select empno,ename,sal from emp
where SAL>=2500;

select * from emp;

-- 15 �������� ���� �ʴ� ����� �̸��� ������ ���Ͻÿ�.
select ename,sal from emp
where comm is null;

-- 16 �Ի����� 82�� ������ ����� ��������� ���Ͻÿ�. 
select * from emp
where to_char(hiredate,'yy')>82;
select * from emp
where hiredate>='82/01/01';

-- 17 ������ 2000�̻� �Ǵ� job�� salesman�� ����� ��������� ���Ͻÿ�.
select upper('saleman') as a, lower('salesman') as b from dual;
select * from emp
where job=upper('saleman') and sal>=2000;

-- 18 ����� �̸��� A�� ���ִ� ����� ��������� ���Ͻÿ�.
select * from emp
where ename like '%A%';

-- 19 ������ ���� ������� �����Ͻÿ�.
select * from emp
order by sal desc;

-- 20 �μ���ȣ�� 10�Ǵ� 20�� ����� �̸��� ������ ���Ͻÿ�
select ename, sal from emp
where deptno in ('10','20');
