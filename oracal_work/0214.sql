drop table ���;
drop table ����;
create table ��� (��� varchar2(10), �̸� varchar2(10));
create table ���� (��� varchar2(10), ���� varchar2(10));
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0001', 'ȫ�浿');
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0002', '��ġ��');
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0003', '�Ȱ���');
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0004', '��ȣ��');
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0005', '�ѱ���');
INSERT INTO "HR"."���" ("���", "�̸�") VALUES ('A0006', '��ȣ��');

INSERT INTO "HR"."����" ("���", "����") VALUES ('A0001', 'T0301');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0002', 'T0302');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0001', 'T0203');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0003', 'T0401');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0005', 'T0501');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0001', 'T0201');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0003', 'T0204');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0003', 'T0306');
INSERT INTO "HR"."����" ("���", "����") VALUES ('A0008', 'T0404');

commit;

select * from ���;
select * from ����;

-- Q1) �̱浿 �л��� ������ ������� ������ ���Ͻÿ�.
select a.�й�, b.����, c.������ from �л� a
inner join ���� b on a.�й� = b.�й�
inner join ���� c on b.��ȣ = c.��ȣ
where �̸�='�̱浿';

select a.�й�, b.����, c.������ from �л� a, ���� b, ���� c
where a.�й� = b.�й� and b.��ȣ = c.��ȣ and �̸�='�̱浿';

-- Q2) �־����� ���� �л��� ��������� ���϶�.
select * from �л� a, ���� b, ���� c
where a.�й� = b.�й� and b.��ȣ = c.��ȣ and �̸� like '��%';

-- Q3) �ֱ浿 �л��� �г�,�̸�,�����ȣ,������ ���Ͻÿ�.
select �г�,�̸�,b.��ȣ,���� from �л� a
inner join ���� b on a.�й�= b.�й�
inner join ���� c on b.��ȣ=c.��ȣ
where �̸�='�ֱ浿';


-- <�ǽ�3> - emp, dept, slagrade ���̺� �̿�
-- Q1) ������ ����� ������ ���� ����� ����Ͻÿ�.(����̸�,����,��޼����� ���)


-- Q2) ������� job�� �μ����� ���Ͻÿ�. (�̸�,job, �μ�������� ���)
select a.ename,a.JOB,b.department_name from emp a,departments b
where a.deptno = b.department_id;
select ename,JOB,department_name from emp
inner join departments on emp.deptno = departments.department_id;




