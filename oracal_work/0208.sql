-- ex1) 학생들의 평균 신장을 구하라
select avg(신장),이름 as a from 학생 group by 이름;

-- ex2) 소속별로 학생들의 평균 신장을 구하시오.
select 소속, round(avg(신장),2) as 평균신장 from 학생 group by 소속; 

-- ex3) 수강테이블에서 학생별 평균성적을 구한후 평균성적이 높은 순서대로 정렬하시오.
select 학번,avg(성적) from 수강 order by 학번;