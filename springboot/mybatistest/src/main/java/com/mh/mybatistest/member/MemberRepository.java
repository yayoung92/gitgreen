package com.mh.mybatistest.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    public void insert();
}
